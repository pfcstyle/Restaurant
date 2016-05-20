package com.pfc.service;

import java.util.ArrayList;

import com.pfc.domain.Dish;

public interface OrderItemService {
	public boolean insertOrderItems(ArrayList<Dish> dishes,int orderId);
}
