package com.hsp.channel;

import java.io.Serializable;

public class Channel implements Serializable {
	private String channel_id;
	private String user_id;
	private String channel_name;
	private String category;
	private String introduction;
	private int delivery_fee;
	private int business_no;
	
	public Channel() {
		
	}
	
	public Channel(String channel_id, String user_id, String channel_name, String category, String introduction,
			int delivery_fee, int business_no) {
		this.channel_id = channel_id;
		this.user_id = user_id;
		this.channel_name = channel_name;
		this.category = category;
		this.introduction = introduction;
		this.delivery_fee = delivery_fee;
		this.business_no = business_no;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getDelivery_fee() {
		return delivery_fee;
	}

	public void setDelivery_fee(int delivery_fee) {
		this.delivery_fee = delivery_fee;
	}

	public int getBusiness_no() {
		return business_no;
	}

	public void setBusiness_no(int business_no) {
		this.business_no = business_no;
	}

	@Override
	public String toString() {
		return "Channel [channel_id=" + channel_id + ", user_id=" + user_id + ", channel_name=" + channel_name
				+ ", category=" + category + ", introduction=" + introduction + ", delivery_fee=" + delivery_fee
				+ ", business_no=" + business_no + "]";
	}
	
}
