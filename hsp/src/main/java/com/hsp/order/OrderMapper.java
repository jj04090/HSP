package com.hsp.order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	public Order select(Order user) throws Exception;
}