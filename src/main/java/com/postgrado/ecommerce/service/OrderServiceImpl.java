package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.MessageDTO;
import com.postgrado.ecommerce.dto.OrderDTO;
import com.postgrado.ecommerce.entity.Order;
import com.postgrado.ecommerce.entity.OrderItem;
import com.postgrado.ecommerce.entity.User;
import com.postgrado.ecommerce.exception.EntityNotFoundException;
import com.postgrado.ecommerce.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;
  private ProductService productService;

  @Override
  public MessageDTO save(OrderDTO dto) {
    Order order = new Order();
    order.setComment(dto.getComment());

    List<OrderItem> items = dto.getItems().stream().map(itemDto -> {
      OrderItem item = new OrderItem();
      item.setQuantity(itemDto.getQuantity());
      item.setProduct(productService.getById(itemDto.getProductId()));
      item.setOrder(order);
      return item;
    }).toList();
    order.setItems(items);

    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    order.setUser(user);

    Order orden = orderRepository.save(order);
    return new MessageDTO("A new order with id " + orden.getId().toString() + " was created.");
  }

  @Override
  public OrderDTO getById(UUID id) {

    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Order", id));

    OrderDTO dto = new OrderDTO();
    dto.setComment(order.getComment());
    dto.setDate(order.getDate());
    dto.setState(order.getState());
    dto.setTotalPrice(orderRepository.getTotalPriceOrder(id));
    dto.setItems(orderRepository.getItemsWithTotalPrice(id));
    return dto;
  }
}
