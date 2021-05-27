package com.hsp.orders;

public class Returns {
	private String return_id;
	private String order_id;
	private String product_id;
	private String return_reason;
	
	public Returns() {
		
	}
	
	public Returns(String return_id, String order_id, String product_id, String return_reason) {
		this.return_id = return_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.return_reason = return_reason;
	}
	public String getReturn_id() {
		return return_id;
	}
	public void setReturn_id(String return_id) {
		this.return_id = return_id;
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
	public String getReturn_reason() {
		return return_reason;
	}
	public void setReturn_reason(String return_reason) {
		this.return_reason = return_reason;
	}

	@Override
	public String toString() {
		return "Returns [return_id=" + return_id + ", order_id=" + order_id + ", product_id=" + product_id
				+ ", return_reason=" + return_reason + "]";
	}
	
	
}
