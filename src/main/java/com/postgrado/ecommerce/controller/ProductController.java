package com.postgrado.ecommerce.controller;

import com.postgrado.ecommerce.dto.PageDTO;
import com.postgrado.ecommerce.dto.ProductDTO;
import com.postgrado.ecommerce.entity.Product;
import com.postgrado.ecommerce.service.ProductService;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody ProductDTO productDTO) {
        Product product = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) {
        Product product = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Product>> getById(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pagina = productService.getProductsPageable(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(pagina);
    }

    @GetMapping
    public ResponseEntity<PageDTO<Product>> getFilteredProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        if (minPrice == null) {
            minPrice = Double.MIN_VALUE;
        }

        if (maxPrice == null) {
            maxPrice = Double.MAX_VALUE;
        }

        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        PageDTO<Product> filteredPage = productService.getFilteredProducts(minPrice, maxPrice,
                pageable);
        return ResponseEntity.status(HttpStatus.OK).body(filteredPage);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategorie(@PathVariable String id) {
        List<ProductDTO> products = productService.getProductsByCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
