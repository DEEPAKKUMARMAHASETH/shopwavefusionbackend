package com.shopwavefusion.service;

import java.util.List;

import com.shopwavefusion.exception.OrderException;
import com.shopwavefusion.modal.Order;
import com.shopwavefusion.modal.User;
import com.shopwavefusion.request.CreateOrderRequest;

public interface OrderService {
	
	public Order createOrder(User user, CreateOrderRequest orderRequest);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId) throws OrderException;
	
	public Order confirmedOrder(Long orderId)throws OrderException;
	
	public Order shippedOrder(Long orderId) throws OrderException;
	
	public Order deliveredOrder(Long orderId) throws OrderException;
	
	public Order cancledOrder(Long orderId) throws OrderException;
	
	public List<Order>getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
	
}
