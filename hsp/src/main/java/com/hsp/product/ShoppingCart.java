package com.hsp.product;

import java.io.Serializable;

public class ShoppingCart implements Serializable {
	private String user_id;
	private String product_id;
	private String product_count;
	private String cart_type;
	
	public ShoppingCart() {
		
	}

	public ShoppingCart(String user_id, String product_id, String product_count, String cart_type) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_count = product_count;
		this.cart_type = cart_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_count() {
		return product_count;
	}

	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}

	public String getCart_type() {
		return cart_type;
	}

	public void setCart_type(String cart_type) {
		this.cart_type = cart_type;
	}

	@Override
	public String toString() {
		return "ShoppingCart [user_id=" + user_id + ", product_id=" + product_id + ", product_count=" + product_count
				+ ", cart_type=" + cart_type + "]";
	}
}
