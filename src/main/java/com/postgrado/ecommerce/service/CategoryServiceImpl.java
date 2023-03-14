package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.entity.Category;
import com.postgrado.ecommerce.exception.EntityNotFoundException;
import com.postgrado.ecommerce.repository.CategoryRepository;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  //@Autowired
  private CategoryRepository categoryRepository;

  //public CategoryServiceImpl(CategoryRepository categoryRepository) {
  //  this.categoryRepository = categoryRepository;
  // }

  @Override
  public Category getById(UUID id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Category", id));
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }
}
