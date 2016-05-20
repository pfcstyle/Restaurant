package com.pfc.dao;

import java.util.ArrayList;

import com.pfc.domain.Order;

public interface IOrderDAO {
	public ArrayList findOrders(int userId);
	public Order findOrder(int orderId);
	public int insertOrder(Order order);
	public int updateOrder(Order order);
	//order和orderItem是级联删除的
	public int deleteOrder(int orderId);
}
