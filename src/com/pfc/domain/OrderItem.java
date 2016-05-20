package com.pfc.domain;

public class OrderItem {
	private int orderitemid;
	private int orderid;
	private String dishname;
	private int dishnums;
	private float dishprice;
	
	public int getorderitemid() {
		return orderitemid;
	}
	public void setorderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}
	public int getorderid() {
		return orderid;
	}
	public void setorderid(int orderid) {
		this.orderid = orderid;
	}
	public String getdishname() {
		return dishname;
	}
	public void setdishname(String dishname) {
		this.dishname = dishname;
	}
	public int getdishnums() {
		return dishnums;
	}
	public void setdishnums(int dishnums) {
		this.dishnums = dishnums;
	}
	public float getdishprice() {
		return dishprice;
	}
	public void setdishprice(float dishprice) {
		this.dishprice = dishprice;
	}
	
	
}
