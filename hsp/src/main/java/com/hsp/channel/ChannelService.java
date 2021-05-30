package com.hsp.channel;

import java.util.List;

import com.hsp.orders.OrderDetail;

public interface ChannelService {
	public void registChannel(Channel channel);
	public void updateChannel(Channel channel);
	public void deleteChannel(Channel channel);
	public List<Channel> viewChannelList(Channel channel);
	public Channel viewChannel(Channel channel);
	
	/* 매출 조회 */
	public List<OrderDetail> viewSales(Channel channel);
	
	/* 구독 */
	public void startSubscribe(Subscribe subscribe);
	public void finishSubscribe(Subscribe subscribe);
	public List<Subscribe> viewSubscribeList(Subscribe subscribe);
	
}
