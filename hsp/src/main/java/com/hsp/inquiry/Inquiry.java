package com.hsp.inquiry;

import java.io.Serializable;

public class Inquiry implements Serializable{
	private String inquiry_id;
	private String user_id;
	private String product_id;
	private String inquiry_title;
	private String inquiry_content;
	private String inquiry_regit_date;
	private String inquiry_type;
	private String answer;

	private int itemStart;
    private int itemSizePerPage;
	
	public Inquiry() {
		
	}
	
	public Inquiry(String inquiry_id, String user_id, String product_id, String inquiry_title, String inquiry_content,
			String inquiry_regit_date, String inquiry_type, String answer, int itemStart, int itemSizePerPage) {
		this.inquiry_id = inquiry_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.inquiry_title = inquiry_title;
		this.inquiry_content = inquiry_content;
		this.inquiry_regit_date = inquiry_regit_date;
		this.inquiry_type = inquiry_type;
		this.answer = answer;
		this.itemStart = itemStart;
		this.itemSizePerPage = itemSizePerPage;
	}

	public String getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
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

	public String getInquiry_title() {
		return inquiry_title;
	}

	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}

	public String getInquiry_regit_date() {
		return inquiry_regit_date;
	}

	public void setInquiry_regit_date(String inquiry_regit_date) {
		this.inquiry_regit_date = inquiry_regit_date;
	}
	
	public String getInquiry_type() {
		return inquiry_type;
	}

	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
		return "Inquiry [inquiry_id=" + inquiry_id + ", user_id=" + user_id + ", product_id=" + product_id
				+ ", inquiry_title=" + inquiry_title + ", inquiry_content=" + inquiry_content + ", inquiry_regit_date="
				+ inquiry_regit_date + ", inquiry_type=" + inquiry_type + ", answer=" + answer + ", itemStart="
				+ itemStart + ", itemSizePerPage=" + itemSizePerPage + "]";
	}
}
