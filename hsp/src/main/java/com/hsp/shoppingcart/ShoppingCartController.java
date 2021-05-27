package com.hsp.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.product.Product;
import com.hsp.user.User;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	// 장바구니 조회
	@GetMapping
	public ModelAndView viewShoppingCart(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/shoppingcart/ShoppingCartView");
		
		return mv;
	}

	// 장바구니 등록
	@PostMapping
	public String registShoppingCart(Product product) {

		return "";
	}

	// 장바구니 수정
	@PutMapping
	public void updateShoppingCart(List<ShoppingCart> list) {

	}

	// 장바구니 삭제
	@DeleteMapping
	public void deleteShoppingCart(ShoppingCart shoppingCart) {

	}
}
