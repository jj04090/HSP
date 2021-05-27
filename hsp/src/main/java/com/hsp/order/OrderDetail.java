package com.hsp.order;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	private String order_id;
	private String product_id;
	private String product_qty;
	private String price;
	private String discount;
	private String delevery_fee;
	private String delevery_status;
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(String order_id, String product_id, String product_qty, String price, String discount,
			String delevery_fee, String delevery_status) {
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_qty = product_qty;
		this.price = price;
		this.discount = discount;
		this.delevery_fee = delevery_fee;
		this.delevery_status = delevery_status;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(String product_qty) {
		this.product_qty = product_qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDelevery_fee() {
		return delevery_fee;
	}
	public void setDelevery_fee(String delevery_fee) {
		this.delevery_fee = delevery_fee;
	}
	public String getDelevery_status() {
		return delevery_status;
	}
	public void setDelevery_status(String delevery_status) {
		this.delevery_status = delevery_status;
	}
	@Override
	public String toString() {
		return "OrderDetail [order_id=" + order_id + ", product_id=" + product_id + ", product_qty=" + product_qty
				+ ", price=" + price + ", discount=" + discount + ", delevery_fee=" + delevery_fee
				+ ", delevery_status=" + delevery_status + "]";
	}
	
	
}
