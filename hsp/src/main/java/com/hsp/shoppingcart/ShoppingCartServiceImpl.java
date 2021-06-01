package com.hsp.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;

	//장바구니 등록
	@Override
	public void registShoppingCart(ShoppingCart shoppingCart) throws Exception {
		shoppingCartMapper.insert(shoppingCart);
	}

	//장바구니 비우기
	@Override
	public void deleteShoppingCart(ShoppingCart shoppingCart) throws Exception {
		shoppingCartMapper.delete(shoppingCart);
	}

	//장바구니 조회
	@Override
	public List<ShoppingCart> viewShoppingCart(ShoppingCart shoppingCart) throws Exception {
		List<ShoppingCart> shoppingList = new ArrayList<ShoppingCart>();
		shoppingList = shoppingCartMapper.list(shoppingCart);
		return shoppingList;
	}

	//장바구니 수정
	@Override
	public List<ShoppingCart> editShoppingCart(ShoppingCart shoppingCart) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}