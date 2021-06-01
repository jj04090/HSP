package com.hsp.orders;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper {
	public OrderInfo select(OrderInfo orderInfo) throws Exception;
	public List<OrderInfo> selectByOrder_id(Map<String, String> order_id) throws Exception;
	public List<OrderInfo> list(OrderInfo orderInfo) throws Exception;
	
	public OrderInfo selectForBizView(Map<String, String> forQuery) throws Exception;
}