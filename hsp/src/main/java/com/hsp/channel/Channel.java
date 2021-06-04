package com.hsp.channel;

import java.io.Serializable;

public class Channel implements Serializable {
	private String channel_id;
	private String user_id;
	private String channel_name;
	private String category;
	private String introduction;
	private String business_no;
	private String bank_name;
	private String account;
	private String auth_code;
	private String access_token;
	private String refresh_token;
	private String user_seq_no;
	
	public Channel() {
		
	}

	public Channel(String channel_id, String user_id, String channel_name, String category, String introduction,
			String business_no, String bank_name, String account, String auth_code, String access_token,
			String refresh_token, String user_seq_no) {
		this.channel_id = channel_id;
		this.user_id = user_id;
		this.channel_name = channel_name;
		this.category = category;
		this.introduction = introduction;
		this.business_no = business_no;
		this.bank_name = bank_name;
		this.account = account;
		this.auth_code = auth_code;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.user_seq_no = user_seq_no;
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

	public String getBusiness_no() {
		return business_no;
	}

	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getUser_seq_no() {
		return user_seq_no;
	}

	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}

	@Override
	public String toString() {
		return "Channel [channel_id=" + channel_id + ", user_id=" + user_id + ", channel_name=" + channel_name
				+ ", category=" + category + ", introduction=" + introduction + ", business_no=" + business_no
				+ ", bank_name=" + bank_name + ", account=" + account + ", auth_code=" + auth_code + ", access_token="
				+ access_token + ", refresh_token=" + refresh_token + ", user_seq_no=" + user_seq_no + "]";
	}

	

	
}
