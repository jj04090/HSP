package com.hsp.product;

import java.io.Serializable;

public class Product implements Serializable {
	private String product_id;
	private String channel_id;
	private String product_img;
	private String product_name;
	private String product_price;
	private String discount;
	private String product_detail;
	private String orderable_cycle;
	
	public Product() {
		
	}
	
	public Product(String product_id, String channel_id, String product_img, String product_name, String product_price,
			String discount, String product_detail, String orderable_cycle) {
		this.product_id = product_id;
		this.channel_id = channel_id;
		this.product_img = product_img;
		this.product_name = product_name;
		this.product_price = product_price;
		this.discount = discount;
		this.product_detail = product_detail;
		this.orderable_cycle = orderable_cycle;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public String getOrderable_cycle() {
		return orderable_cycle;
	}
	public void setOrderable_cycle(String orderable_cycle) {
		this.orderable_cycle = orderable_cycle;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", channel_id=" + channel_id + ", product_img=" + product_img
				+ ", product_name=" + product_name + ", product_price=" + product_price + ", discount=" + discount
				+ ", product_detail=" + product_detail + ", orderable_cycle=" + orderable_cycle + "]";
	}
	
	
}
