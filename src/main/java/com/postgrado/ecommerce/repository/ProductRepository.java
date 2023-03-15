package com.postgrado.ecommerce.repository;

import com.postgrado.ecommerce.dto.ProductDTO;
import com.postgrado.ecommerce.entity.Product;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    //ProductDTO findByCategory(UUID categoryId);

    @Query(value = "SELECT * "
            + "FROM products  "
            + "WHERE products.category_id = ?1", nativeQuery = true)
   List<ProductDTO> getProductCat(String categoryId);
}
