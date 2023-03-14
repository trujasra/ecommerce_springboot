package com.postgrado.ecommerce.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.postgrado.ecommerce.entity.OrderSate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

  private String comment;

  private List<OrderItemDTO> items;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime date;

  @JsonProperty(access = Access.READ_ONLY)
  private OrderSate state;

  @JsonProperty(access = Access.READ_ONLY)
  private double totalPrice;
}
