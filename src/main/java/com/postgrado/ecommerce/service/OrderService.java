package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.OrderDTO;
import java.util.UUID;

public interface OrderService {

  String save(OrderDTO orderDTO);

  OrderDTO getById(UUID id);
}
