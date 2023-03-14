package com.postgrado.ecommerce.dto;

import com.postgrado.ecommerce.entity.Product;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PageDTO<T> {

  private List<T> content;
  private boolean isLast;
  private int pageNumber;
  private int pageSize;
  private int totalPages;
  private long totalElements;

}
