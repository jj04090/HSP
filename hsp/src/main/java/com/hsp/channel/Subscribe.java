package com.hsp.channel;

import java.io.Serializable;

public class Subscribe implements Serializable {
	private String user_id;
	private String channel_id;
	
	public Subscribe() {
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	@Override
	public String toString() {
		return "Subscribe [user_id=" + user_id + ", channel_id=" + channel_id + "]";
	}
}
