package com.hsp.order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
	public Order select(Order user) throws Exception;
}