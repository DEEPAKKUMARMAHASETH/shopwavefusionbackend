package com.shopwavefusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwavefusion.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
