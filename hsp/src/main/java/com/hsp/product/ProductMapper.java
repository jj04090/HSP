package com.hsp.product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public Product select(Product user) throws Exception;
}