package com.hsp.orders;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper {
	public OrderInfo select(OrderInfo orderInfo) throws Exception;
	public List<OrderInfo> selectByOrder_id(Map<String, String> order_idO) throws Exception;
	public List<OrderInfo> selectForBiz(String order_id) throws Exception;
	public List<OrderInfo> list(OrderInfo orderInfo) throws Exception;
}