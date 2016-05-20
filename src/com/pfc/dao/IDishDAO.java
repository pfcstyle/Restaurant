package com.pfc.dao;

import java.util.ArrayList;

import com.pfc.domain.Dish;


public interface IDishDAO {
	//分页查询
	public ArrayList<Dish> findDishes(int pageNow,int pageSize);
	public Dish findDish(int dishId);
	public int insertDish(Dish dish);
	public int updateDish(Dish dish);
	public int deleteDish(int dishId);
	public int getCount();
}
