package com.hsp.channel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ChannelService {
	/* 채널 */
	public void registChannel(Channel channel, MultipartFile attach);
	public void updateChannel(Channel channel, MultipartFile attach);
	public void deleteChannel(Channel channel);
	public Channel viewChannel(Channel channel);
	public List<Channel> viewChannelList();
	
	/* 구독 */
	public void startSubscribe(Subscribe subscribe);
	public void finishSubscribe(Subscribe subscribe);
	public Subscribe viewSubscribe(Subscribe subscribe);
	public List<Subscribe> viewSubscribeList(Subscribe subscribe);
	public List<String> checkSubs(List<Channel> channelList, String user_id);
	
	public String imgUpload(MultipartFile attach);
	public ResponseEntity<Resource> display(String fileName);
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, MultipartFile upload);
	
}
