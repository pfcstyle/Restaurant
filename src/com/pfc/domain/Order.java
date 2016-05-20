package com.pfc.domain;
import java.util.*;

public class Order {
	private int orderid;
	private int userid;
	private String ordercreatedate;
	private float orderprice;
	
	public int getorderid() {
		return orderid;
	}
	public void setorderid(int orderid) {
		this.orderid = orderid;
	}
	public int getuserid() {
		return userid;
	}
	public void setuserid(int userid) {
		this.userid = userid;
	}
	public String getordercreatedate() {
		return ordercreatedate;
	}
	public void setordercreatedate(String ordercreatedate) {
		this.ordercreatedate = ordercreatedate;
	}
	public float getorderprice() {
		return orderprice;
	}
	public void setorderprice(float orderprice) {
		this.orderprice = orderprice;
	}
	
	
}
