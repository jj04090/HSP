package com.hsp.user;

import java.io.Serializable;

public class User implements Serializable {
    private String user_id;
    private String phone;
    private String name;
    private String password;
    private String address;
    private String detail_add;
    private String zip_code;
    private String email;
    private String user_type;
    private String regit_date;

    private int itemStart;
    private int itemSizePerPage;
    
    public User() {
    	
    }

	public User(String user_id, String phone, String name, String password, String address, String detail_add,
			String zip_code, String email, String user_type, String regit_date, int itemStart, int itemSizePerPage) {
		super();
		this.user_id = user_id;
		this.phone = phone;
		this.name = name;
		this.password = password;
		this.address = address;
		this.detail_add = detail_add;
		this.zip_code = zip_code;
		this.email = email;
		this.user_type = user_type;
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

	public String getDetail_add() {
		return detail_add;
	}

	public void setDetail_add(String detail_add) {
		this.detail_add = detail_add;
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

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
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
    
    
}