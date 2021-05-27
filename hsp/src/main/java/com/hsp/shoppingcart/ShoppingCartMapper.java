package com.hsp.shoppingcart;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
	public List<ShoppingCart> list(ShoppingCart shoppingCart) throws Exception;

	public ShoppingCart select(ShoppingCart shoppingCart) throws Exception;

	public void insert(ShoppingCart shoppingCart) throws Exception;

	public void update(ShoppingCart shoppingCart) throws Exception;

	public void delete(ShoppingCart shoppingCart) throws Exception;
}