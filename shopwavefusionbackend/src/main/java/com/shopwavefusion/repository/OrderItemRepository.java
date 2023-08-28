package com.shopwavefusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwavefusion.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
