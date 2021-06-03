package com.hsp.community;

import java.io.Serializable;

public class Comment implements Serializable{
	private String comment_id;
	private String community_id;
	private String user_id;
	private String comment_content;
	private String regit_date;
	
	private int itemStart;
    private int itemSizePerPage;
    
    public Comment() {
    	
    }
    
	public Comment(String comment_id, String community_id, String user_id, String comment_content, String regit_date,
			int itemStart, int itemSizePerPage) {
		super();
		this.comment_id = comment_id;
		this.community_id = community_id;
		this.user_id = user_id;
		this.comment_content = comment_content;
		this.regit_date = regit_date;
		this.itemStart = itemStart;
		this.itemSizePerPage = itemSizePerPage;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", community_id=" + community_id + ", user_id=" + user_id
				+ ", comment_content=" + comment_content + ", regit_date=" + regit_date + ", itemStart=" + itemStart
				+ ", itemSizePerPage=" + itemSizePerPage + "]";
	}
	
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(String community_id) {
		this.community_id = community_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
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