package com.hsp.orders;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
	public OrderDetail select(OrderDetail orderDetail) throws Exception;
	public OrderDetail mostSelling() throws Exception;
	public List<OrderDetail> list(OrderDetail orderDetail) throws Exception;
	public void statusUpdate(OrderDetail orderDetail) throws Exception;
	public void insert(OrderDetail orderDetail) throws Exception;
}