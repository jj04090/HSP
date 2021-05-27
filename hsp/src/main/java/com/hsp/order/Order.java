package com.hsp.order;

import java.io.Serializable;

public class Order implements Serializable {
	private String order_id;
	private String user_id;
	private String order_type;
	private String order_date;
	private String order_status;
	
	public Order() {
		
	}
	
	public Order(String order_id, String user_id, String order_type, String order_date, String order_status) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_type = order_type;
		this.order_date = order_date;
		this.order_status = order_status;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", order_type=" + order_type + ", order_date="
				+ order_date + ", order_status=" + order_status + "]";
	}
	
	
}
