package com.hsp.orders;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
	public Orders select(Orders order) throws Exception;
	public List<Orders> list(Orders order) throws Exception;
}