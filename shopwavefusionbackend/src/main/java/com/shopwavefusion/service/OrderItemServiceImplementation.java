package com.shopwavefusion.service;

import org.springframework.stereotype.Service;

import com.shopwavefusion.model.OrderItem;
import com.shopwavefusion.repository.OrderItemRepository;

@Service
public class OrderItemServiceImplementation implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	public OrderItemServiceImplementation(OrderItemRepository orderItemRepository) {
		this.orderItemRepository=orderItemRepository;
	}
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

}
