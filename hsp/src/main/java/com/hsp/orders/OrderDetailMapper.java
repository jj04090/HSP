package com.hsp.orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
	public Orders select(Orders user) throws Exception;
}