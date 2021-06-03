package com.hsp.review;

import java.io.Serializable;

public class Review implements Serializable{
	private String review_id;
	private String order_id;
	private String product_id;
	private String product_grade;
	private String review_title;
	private String review_content;
	private String review_img;
	
	private int itemStart;
    private int itemSizePerPage;
	
	public Review() {
		
	}

	public Review(String review_id, String order_id, String product_id, String product_grade, String review_title,
			String review_content, String review_img, int itemStart, int itemSizePerPage) {
		this.review_id = review_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_grade = product_grade;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_img = review_img;
		this.itemStart = itemStart;
		this.itemSizePerPage = itemSizePerPage;
	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
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

	public String getProduct_grade() {
		return product_grade;
	}

	public void setProduct_grade(String product_grade) {
		this.product_grade = product_grade;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_img() {
		return review_img;
	}

	public void setReview_img(String review_img) {
		this.review_img = review_img;
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
		return "Review [review_id=" + review_id + ", order_id=" + order_id + ", product_id=" + product_id
				+ ", product_grade=" + product_grade + ", review_title=" + review_title + ", review_content="
				+ review_content + ", review_img=" + review_img + ", itemStart=" + itemStart + ", itemSizePerPage="
				+ itemSizePerPage + "]";
	}
}
