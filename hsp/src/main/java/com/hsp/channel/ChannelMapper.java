package com.hsp.channel;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChannelMapper {
	public Channel select(Channel channel) throws Exception;
	public List<Channel> list(Channel channel) throws Exception;
	
}