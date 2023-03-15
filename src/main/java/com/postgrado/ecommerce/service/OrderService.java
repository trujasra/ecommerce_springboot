package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.MessageDTO;
import com.postgrado.ecommerce.dto.OrderDTO;
import java.util.UUID;

public interface OrderService {

  MessageDTO save(OrderDTO orderDTO);

  OrderDTO getById(UUID id);
}
