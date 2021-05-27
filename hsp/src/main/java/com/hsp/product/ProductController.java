package com.hsp.product;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.user.User;

@RestController
@RequestMapping("/product")
public class ProductController {

	// 장바구니 조회
	@GetMapping("/shoppingcart")
	public ModelAndView viewShoppingCart(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/product/shoppingCartView");

		return mv;
	}

	// 장바구니 등록
	@PostMapping("/shoppingcart")
	public String registShoppingCart(Product product) {

		return "";
	}

	// 장바구니 수정
	@PutMapping("/shoppingcart")
	public void updateShoppingCart(List<ShoppingCart> list) {

	}

	// 장바구니 삭제
	@DeleteMapping("/shoppingcart")
	public void deleteShoppingCart(ShoppingCart shoppingCart) {

	}
}
