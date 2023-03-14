package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.PageDTO;
import com.postgrado.ecommerce.dto.ProductDTO;
import com.postgrado.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  Product save(ProductDTO productDTO);

  Product getById(UUID id);

  Page<Product> getProductsPageable(Pageable pageable);

  PageDTO<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable);

}
