package com.hsp.orders;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReturnsMapper {
	public Returns select(Returns returns) throws Exception;
	public List<Returns> list(Returns returns) throws Exception;
	public void insert(Returns returns) throws Exception;
}