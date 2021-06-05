package com.hsp.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.product.Product;
import com.hsp.product.ProductMapper;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;

	@Autowired
	private ProductMapper productMapper;

	// 장바구니 등록
	@Override
	public void registShoppingCart(ShoppingCart shoppingCart) throws Exception {
		ShoppingCart sc = shoppingCartMapper.select(shoppingCart);
		if (sc != null) {
			shoppingCartMapper.update(shoppingCart);
		} else {
			shoppingCartMapper.insert(shoppingCart);
		}
	}

	// 장바구니 비우기
	@Override
	public void deleteShoppingCart(ShoppingCart shoppingCart) throws Exception {
		shoppingCartMapper.delete(shoppingCart);
	}

	// 장바구니 조회
	@Override
	public List<CartValue> viewShoppingCart(ShoppingCart shoppingCart) throws Exception {
		Product product = new Product();
		List<CartValue> sl = new ArrayList<CartValue>();
		List<ShoppingCart> shoppingList = new ArrayList<ShoppingCart>();
		shoppingList = shoppingCartMapper.list(shoppingCart);

		for (ShoppingCart sc : shoppingList) {
			product.setProduct_id(sc.getProduct_id());
			CartValue temp = new CartValue();
			temp.setProduct(productMapper.select(product));
			temp.setShoppingCart(sc);
			sl.add(temp);
		}

		return sl;
	}

	// 장바구니 수정
	@Override
	public void editShoppingCart(List<ShoppingCart> list) throws Exception {
		for (ShoppingCart shoppingCart : list) {
			shoppingCartMapper.update(shoppingCart);
		}
	}
}