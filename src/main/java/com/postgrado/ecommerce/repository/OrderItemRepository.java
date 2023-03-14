package com.postgrado.ecommerce.repository;

import com.postgrado.ecommerce.entity.OrderItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

}
