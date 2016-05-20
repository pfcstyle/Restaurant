package com.pfc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.pfc.domain.Dish;

public class MyCart {
	private HashMap<String,Dish> hm = new HashMap<String,Dish>();
	private float totalPrice;
	
	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice() {
		Iterator iterator = hm.keySet().iterator();
		float tp=0;
		while(iterator.hasNext()){
			String id = (String)iterator.next();
			Dish dish = hm.get(id);
			tp+=(dish.getBuyNum()*dish.getdishnowprice());
		}
		this.totalPrice = tp;
	}

	//显示该购物车中所有商品信息
	public ArrayList<Dish> getAllDishes(){
		ArrayList<Dish> dishs = new ArrayList<Dish>();
		Iterator iterator = hm.keySet().iterator();
		while(iterator.hasNext()){
			String id = (String)iterator.next();
			Dish dish = hm.get(id);
			dishs.add(dish);
		}
		return dishs;
	}
	
	//添加
	public void addDish(String id,Dish dish){
		if(hm.containsKey(id)){
			Dish d = hm.get(id);
			int buyNum = d.getBuyNum()+1;
			d.setBuyNum(buyNum);
			hm.put(id, d);
		}
		else{
			dish.setBuyNum(1);
			hm.put(id, dish);
		}
	}
	
	//删除
	public void delDish(String id){
		hm.remove(id);
	}
	
	//修改
	public void updateDishNum(String[] bookNums){
		Iterator iterator = hm.keySet().iterator();
		int i=0;
		while(iterator.hasNext()){
			String id = (String)iterator.next();
			Dish dish = hm.get(id);
			dish.setBuyNum(Integer.parseInt(bookNums[i]));
			i++;
			hm.put(id, dish);
		}
	}
	
	public void updateTotalPrice(){
		
	}
	
	//清空
	public void clearCart(){
		hm.clear();
	}

}
