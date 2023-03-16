package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.PageDTO;
import com.postgrado.ecommerce.dto.ProductDTO;
import com.postgrado.ecommerce.entity.Category;
import com.postgrado.ecommerce.entity.Product;
import com.postgrado.ecommerce.exception.EntityNotFoundException;
import com.postgrado.ecommerce.mapper.ProductMapper;
import com.postgrado.ecommerce.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private CategoryService categoryService;
  private ProductRepository productRepository;

  private ProductMapper productMapper;

  @Override
  public Product save(ProductDTO productDTO) {

    Category category = categoryService.getById(productDTO.getCategoryId());
    Product product = productMapper.convertToProduct(productDTO);
    product.setCategory(category);

    return productRepository.save(product);
  }

  @Override
  public Product getById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));
  }

  @Override
  public Page<Product> getProductsPageable(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public PageDTO<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    return productMapper.convertToPageDTO(page);
  }

  @Override
  public List<ProductDTO> getProductByCategory(String categoryId) {
    List<Product> product = productRepository.getProductByCategory(categoryId);
    List<ProductDTO> response = product.stream().map(productDto -> {
      ProductDTO dto = new ProductDTO();
      dto.setActive(productDto.getActive());
      dto.setDescription(productDto.getDescription());
      dto.setImageUrl(productDto.getImageUrl());
      dto.setImageUrl(productDto.getImageUrl());
      dto.setName(productDto.getName());
      dto.setPrice(productDto.getPrice());
      dto.setStock(productDto.getStock());
      dto.setCategoryId(productDto.getCategory().getId());
      return dto;
    }).toList();
    return response;
  }

  @Override
  public Product updateProduct(UUID id, ProductDTO productDTO) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));

    Category category = categoryService.getById(productDTO.getCategoryId());

    product.setActive(productDTO.isActive());
    product.setDescription(productDTO.getDescription());
    product.setImageUrl(productDTO.getImageUrl());
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setStock(productDTO.getStock());
    product.setCategory(category);

    productRepository.save(product);
    return product;
  }
}
