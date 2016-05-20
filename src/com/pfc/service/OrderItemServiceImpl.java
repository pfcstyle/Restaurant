package com.pfc.service;

import java.util.ArrayList;

import com.pfc.dao.IOrderItemDAO;
import com.pfc.domain.Dish;
import com.pfc.domain.OrderItem;
import com.pfc.util.DaoFactory;

public class OrderItemServiceImpl implements OrderItemService{

	@Override
	public boolean insertOrderItems(ArrayList<Dish> dishes, int orderId) {
		// TODO Auto-generated method stub
		IOrderItemDAO orderitemdao = (IOrderItemDAO)DaoFactory.newInstance("IOrderItemDAO");
		for(Dish dish : dishes){
			OrderItem item = new OrderItem();
			item.setdishname(dish.getdishname());
			item.setdishnums(dish.getBuyNum());
			item.setdishprice(dish.getdishnowprice());
			item.setorderid(orderId);
			orderitemdao.insertOrderItem(item);
		}
		return true;
	}

	



}
