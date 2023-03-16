package com.postgrado.ecommerce.mapper;

import com.postgrado.ecommerce.dto.PageDTO;
import com.postgrado.ecommerce.dto.ProductDTO;
import com.postgrado.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product convertToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        product.setStock(productDTO.getStock());
        product.setActive(productDTO.isActive());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public PageDTO<Product> convertToPageDTO(Page<Product> product) {
        PageDTO<Product> dto = new PageDTO<>();
        dto.setContent(product.getContent());
        dto.setPageNumber(product.getNumber());
        dto.setPageSize(product.getSize());
        dto.setTotalPages(product.getTotalPages());
        dto.setTotalElements(product.getTotalElements());
        dto.setLast(product.isLast());
        return dto;
    }

    public ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setStock(product.getStock());
        productDTO.setActive(product.getActive());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
