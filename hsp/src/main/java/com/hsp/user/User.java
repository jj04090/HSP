package com.hsp.user;

import java.io.Serializable;

public class User implements Serializable {
    private String user_id;
    private String phone;
    private String name;
    private String password;
    private String address;
    private String detail_address;
    private String zip_code;
    private String email;
    private String bank_name;
    private String account_number;
    private String auth;
    private String regit_date;

    private int itemStart;
    private int itemSizePerPage;
    
    public User() {
    	
    }

	public User(String user_id, String phone, String name, String password, String address, String detail_address,
			String zip_code, String email, String bank_name, String account_number, String auth, String regit_date,
			int itemStart, int itemSizePerPage) {
		this.user_id = user_id;
		this.phone = phone;
		this.name = name;
		this.password = password;
		this.address = address;
		this.detail_address = detail_address;
		this.zip_code = zip_code;
		this.email = email;
		this.bank_name = bank_name;
		this.account_number = account_number;
		this.auth = auth;
		this.regit_date = regit_date;
		this.itemStart = itemStart;
		this.itemSizePerPage = itemSizePerPage;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getRegit_date() {
		return regit_date;
	}

	public void setRegit_date(String regit_date) {
		this.regit_date = regit_date;
	}

	public int getItemStart() {
		return itemStart;
	}

	public void setItemStart(int itemStart) {
		this.itemStart = itemStart;
	}

	public int getItemSizePerPage() {
		return itemSizePerPage;
	}

	public void setItemSizePerPage(int itemSizePerPage) {
		this.itemSizePerPage = itemSizePerPage;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", phone=" + phone + ", name=" + name + ", password=" + password
				+ ", address=" + address + ", detail_address=" + detail_address + ", zip_code=" + zip_code + ", email="
				+ email + ", bank_name=" + bank_name + ", account_number=" + account_number + ", auth=" + auth
				+ ", regit_date=" + regit_date + ", itemStart=" + itemStart + ", itemSizePerPage=" + itemSizePerPage
				+ "]";
	}
    
}