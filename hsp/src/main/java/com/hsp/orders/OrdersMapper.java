package com.hsp.orders;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
	public Orders select(Orders orders) throws Exception;
	public List<Orders> list(Orders orders) throws Exception;
	public List<Orders> selectByChannelId(String channel_id) throws Exception;
	public void update(Orders orders) throws Exception;
	public void insert(Orders orders) throws Exception;
}