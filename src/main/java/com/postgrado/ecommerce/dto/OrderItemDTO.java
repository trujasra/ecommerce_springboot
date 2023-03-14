package com.postgrado.ecommerce.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDTO {

  private int quantity;

  private UUID productId;

  @JsonProperty(access = Access.READ_ONLY)
  private double totalPrice;

  public OrderItemDTO(UUID productId, int quantity, double totalPrice) {
    this.quantity = quantity;
    this.productId = productId;
    this.totalPrice = totalPrice;
  }
}
