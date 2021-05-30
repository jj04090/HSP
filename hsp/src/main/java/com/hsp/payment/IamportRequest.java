package com.hsp.payment;

import java.io.Serializable;

public class IamportRequest implements Serializable {
	
	private String pg;
	private String pay_method = "card";
	private String merchant_uid;
	private String name;
	private int amount;
	private String buyer_email;
	private String buyer_name;
	private String customer_uid;
	public IamportRequest() {
	}
	
	public IamportRequest(String pg, String merchant_uid, String name, int amount,
			String buyer_email, String buyer_name) {
		this.pg = pg;
		this.merchant_uid = merchant_uid;
		this.name = name;
		this.amount = amount;
		this.buyer_email = buyer_email;
		this.buyer_name = buyer_name;
	}

	public IamportRequest(String pg, String merchant_uid, String name, int amount,
			String buyer_email, String buyer_name, String customer_uid) {
		this.pg = pg;
		this.merchant_uid = merchant_uid;
		this.name = name;
		this.amount = amount;
		this.buyer_email = buyer_email;
		this.buyer_name = buyer_name;
		this.customer_uid = customer_uid;
	}

	public String getCustomer_uid() {
		return customer_uid;
	}

	public void setCustomer_uid(String customer_uid) {
		this.customer_uid = customer_uid;
	}

	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBuyer_email() {
		return buyer_email;
	}
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	@Override
	public String toString() {
		return "IamportRequest [pg=" + pg + ", pay_method=" + pay_method + ", merchant_uid=" + merchant_uid + ", name="
				+ name + ", amount=" + amount + ", buyer_email=" + buyer_email + ", buyer_name=" + buyer_name
				+ ", customer_uid=" + customer_uid + "]";
	}
	
	
	
}
