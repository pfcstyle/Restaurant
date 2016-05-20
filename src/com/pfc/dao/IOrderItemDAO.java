package com.pfc.dao;

import java.util.ArrayList;
import com.pfc.domain.OrderItem;

public interface IOrderItemDAO {
	public ArrayList findOrderItems(int orderId);
	public OrderItem findOrderItem(int orderItemId);
	public int insertOrderItem(OrderItem orderItem);
	public int updateOrderItem(OrderItem orderItem);
	//order和orderItem是级联删除的
	public int deleteOrderItem(int orderItemId);
}
