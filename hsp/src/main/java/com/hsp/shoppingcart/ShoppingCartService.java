package com.hsp.shoppingcart;

import java.util.List;

import com.hsp.product.Product;

public interface ShoppingCartService {
	
	//장바구니 등록
	public void registShoppingCart(ShoppingCart shoppingCart) throws Exception;
	
	//장바구니 비우기
	public void deleteShoppingCart(ShoppingCart shoppingCart) throws Exception;
	
	//장바구니 수정
	public List<ShoppingCart> editShoppingCart(ShoppingCart shoppingCart) throws Exception;
		
	//장바구니 조회
	public List<ShoppingCart> viewShoppingCart(ShoppingCart shoppingCart) throws Exception;
}
