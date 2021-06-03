package com.hsp.orders;

import java.io.Serializable;

public class OrderInfo implements Serializable{
	private String order_id;
	private String user_id;
	private String order_type;
	private String product_name;
	private String product_id;
	private String product_img;
	private String product_qty;
	private String price;
	private String discount;
	private String delevery_status;
	private String name;
	private String address;
	private String detail_address;
	private String zip_code;
	
	public OrderInfo() {
		
	}
	
	public OrderInfo(String order_id, String user_id, String order_type, String product_name, String product_id,
			String product_img, String product_qty, String price, String discount,
			String delevery_status, String name, String address, String detail_address, String zip_code) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_type = order_type;
		this.product_name = product_name;
		this.product_id = product_id;
		this.product_img = product_img;
		this.product_qty = product_qty;
		this.price = price;
		this.discount = discount;
		this.delevery_status = delevery_status;
		this.name = name;
		this.address = address;
		this.detail_address = detail_address;
		this.zip_code = zip_code;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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

	public String getDelevery_status() {
		return delevery_status;
	}

	public void setDelevery_status(String delevery_status) {
		this.delevery_status = delevery_status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "OrderInfo [order_id=" + order_id + ", user_id=" + user_id + ", order_type=" + order_type
				+ ", product_name=" + product_name + ", product_id=" + product_id + ", product_img=" + product_img
				+ ", product_qty=" + product_qty + ", price=" + price + ", discount=" + discount + ", delevery_status="
				+ delevery_status + ", name=" + name + ", address=" + address + ", detail_address=" + detail_address
				+ ", zip_code=" + zip_code + "]";
	}
	
	
	
}
