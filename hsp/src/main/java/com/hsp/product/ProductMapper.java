package com.hsp.product;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public Product select(Product product) throws Exception;
	public List<Product> sellingList() throws Exception;
	public List<Product> list(Product product) throws Exception;
	public void insert(Product product) throws Exception;
	public void update(Product product) throws Exception;
}