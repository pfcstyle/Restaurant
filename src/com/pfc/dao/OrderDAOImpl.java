package com.pfc.dao;

import java.util.ArrayList;

import com.pfc.domain.Order;

public class OrderDAOImpl extends baseDAO implements IOrderDAO {

	
	@Override
	public int insertOrder(Order order) {
		// TODO Auto-generated method stub
		String sql = "insert into `order` values(?,?,?,?)";
		Object[] params = {order.getorderid(),order.getuserid(),order.getordercreatedate(),order.getorderprice()};
		return updateObj(sql, params);
	}

	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList findOrders(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from order where userid = ?";
		Object parameters[] = {userId};
		ArrayList<Order> arr = findObjs(sql, parameters, Order.class);
		return arr;
	}

	@Override
	public Order findOrder(int orderId) {
		// TODO Auto-generated method stub
		String sql = "select * from order where orderid = ?";
		Object parameters[] = {orderId};
		Order order = (Order)findObj(sql, parameters, Order.class);
		return order;
	}

}
