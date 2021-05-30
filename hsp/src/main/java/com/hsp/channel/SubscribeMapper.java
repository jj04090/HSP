package com.hsp.channel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeMapper {
	public Subscribe insert(Subscribe subscribe) throws Exception;
	public Subscribe delete(Subscribe subscribe) throws Exception;
	
}