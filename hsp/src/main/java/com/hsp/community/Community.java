package com.hsp.community;

import java.io.Serializable;

public class Community implements Serializable{
	private String community_id;
	private String channel_id;
	private String community_title;
	private String community_content;
	private String regit_date;
	private String mediafile;
	
	private int itemStart;
    private int itemSizePerPage;
    
    public Community() {
    	
    }

	public Community(String community_id, String channel_id, String community_title, String community_content,
			String regit_date, String mediafile, int itemStart, int itemSizePerPage) {
		this.community_id = community_id;
		this.channel_id = channel_id;
		this.community_title = community_title;
		this.community_content = community_content;
		this.regit_date = regit_date;
		this.mediafile = mediafile;
		this.itemStart = itemStart;
		this.itemSizePerPage = itemSizePerPage;
	}

	public String getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(String community_id) {
		this.community_id = community_id;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getCommunity_title() {
		return community_title;
	}
	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}
	public String getCommunity_content() {
		return community_content;
	}
	public void setCommunity_content(String community_content) {
		this.community_content = community_content;
	}
	public String getRegit_date() {
		return regit_date;
	}
	public void setRegit_date(String regit_date) {
		this.regit_date = regit_date;
	}
	public String getMediafile() {
		return mediafile;
	}
	public void setMediafile(String mediafile) {
		this.mediafile = mediafile;
	}
	
	@Override
	public String toString() {
		return "Community [community_id=" + community_id + ", channel_id=" + channel_id + ", community_title="
				+ community_title + ", community_content=" + community_content + ", regit_date=" + regit_date
				+ ", mediafile=" + mediafile + ", itemStart=" + itemStart + ", itemSizePerPage=" + itemSizePerPage
				+ "]";
	}
}
