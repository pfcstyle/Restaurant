package com.pfc.dao;

import java.util.ArrayList;

import com.pfc.domain.Order;
import com.pfc.domain.OrderItem;

public class OrderItemDAOImpl extends baseDAO implements IOrderItemDAO{

	@Override
	public int insertOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		String sql = "insert into `orderitem` (orderid,dishname,dishnums,dishprice) values(?,?,?,?)";
		Object[] params = {orderItem.getorderid(),orderItem.getdishname(),orderItem.getdishnums(),orderItem.getdishprice()};
		return updateObj(sql, params);
	}

	@Override
	public int updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList findOrderItems(int orderId) {
		// TODO Auto-generated method stub
		String sql = "select * from orderitem where orderid = ?";
		Object parameters[] = {orderId};
		ArrayList<Order> arr = findObjs(sql, parameters, OrderItem.class);
		return arr;
	}

	@Override
	public OrderItem findOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		String sql = "select * from orderitem where orderitemid = ?";
		Object parameters[] = {orderItemId};
		ArrayList<Order> arr = findObjs(sql, parameters, OrderItem.class);
		return null;
	}

}
