package com.hsp.orders;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
	public OrderDetail select(OrderDetail orderDetail) throws Exception;
	public List<OrderDetail> list(OrderDetail orderDetail) throws Exception;
	public List<OrderDetail> selectByChannelId(String channel_id) throws Exception;
	public void statusUpdate(OrderDetail orderDetail) throws Exception;
}