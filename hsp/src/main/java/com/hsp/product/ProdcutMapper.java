package com.hsp.product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProdcutMapper {
	public Product select(Product user) throws Exception;
}