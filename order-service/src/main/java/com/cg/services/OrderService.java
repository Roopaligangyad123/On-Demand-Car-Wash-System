package com.cg.services;

import java.util.List;

import com.cg.models.OrderDetails;

public interface OrderService {
	
	public OrderDetails addOrder(OrderDetails order);
	public List<OrderDetails> orderDetails();
	public OrderDetails updateOrder(OrderDetails update);
	public void deleteById(int id);
	public int getSequenceNumber(String sequenceName);
	public boolean existsById(int id);

}
