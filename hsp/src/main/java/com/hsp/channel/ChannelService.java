package com.hsp.channel;

import java.util.List;

import com.hsp.orders.OrderDetail;

public interface ChannelService {
	/* 채널 */
	public void registChannel(Channel channel);
	public void updateChannel(Channel channel);
	public void deleteChannel(Channel channel);
	public Channel viewChannel(Channel channel);
	public List<Channel> viewChannelList(Channel channel);
	
	/* 구독 */
	public void startSubscribe(Subscribe subscribe);
	public void finishSubscribe(Subscribe subscribe);
	public List<Subscribe> viewSubscribeList(Subscribe subscribe);
	
}
