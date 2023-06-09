package com.postgrado.ecommerce.controller;

import com.postgrado.ecommerce.dto.MessageDTO;
import com.postgrado.ecommerce.dto.OrderDTO;
import com.postgrado.ecommerce.dto.OrderItemDTO;
import com.postgrado.ecommerce.repository.OrderRepository;
import com.postgrado.ecommerce.service.OrderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

  private OrderService orderService;

  private OrderRepository orderRepository;

  @PostMapping
  public ResponseEntity<MessageDTO> save(@RequestBody OrderDTO orderDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderDTO));
  }

  /*@GetMapping("/total/{id}")
  public Map<String, Object> getTotalPrice(@PathVariable UUID id) {
    Map<String, Object> result = new HashMap<>();
    *//*result.put("totalPrice-SQL", orderRepository.getTotalPrice(id.toString()));*//*
    result.put("totalPrice-JPQL", orderRepository.getTotalPriceOrder(id));
    return result;
  }

  @GetMapping("/items/{id}")
  public List<OrderItemDTO> getItemsWhitPrice(@PathVariable UUID id) {
    return orderRepository.getItemsWithTotalPrice(id);
  }*/

  @GetMapping("/{id}")
  public ResponseEntity<OrderDTO> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(orderService.getById(id));
  }
}
