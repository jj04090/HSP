package com.hsp.channel;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChannelMapper {
	public Channel insert(Channel channel) throws Exception;
	public void update(Channel channel) throws Exception;
	public Channel delete(Channel channel) throws Exception;
	public Channel select(Channel channel) throws Exception;
	public List<Channel> list() throws Exception;
	public List<Channel> topChannel() throws Exception;
	public Channel selectByProductId(String product_id) throws Exception;
}