package com.hsp.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.orders.OrderServiceImpl;
import com.hsp.user.User;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	@Autowired
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	// 장바구니 조회
	@GetMapping("/{cartType}")
	public ModelAndView viewShoppingCart(@PathVariable String cartType) {
		ModelAndView mv = new ModelAndView();
		User getUser = (User)httpSession.getAttribute("user");
		mv.setViewName("/shoppingcart/shoppingCart");
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCart_type(cartType);
		shoppingCart.setUser_id(getUser.getUser_id()); //세션에서 가져오기
		
		try {
			List<CartValue> shoppingList = new ArrayList<CartValue>();
			
			shoppingList = shoppingCartServiceImpl.viewShoppingCart(shoppingCart);
			
			mv.addObject("shoppingList", shoppingList);
			mv.addObject("total", orderServiceImpl.totalPrice(getUser.getUser_id(), cartType));
			mv.addObject("cartType", cartType.toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	// 장바구니 등록
	@PostMapping
//	@ResponseBody
	public ModelAndView registShoppingCart(ShoppingCart shoppingCart) {
		ModelAndView modelAndView = new ModelAndView("redirect:/shoppingcart/"+shoppingCart.getCart_type());
		try {
			shoppingCartServiceImpl.registShoppingCart(shoppingCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	// 장바구니 수정
	@PutMapping
	public void updateShoppingCart(@RequestBody ArrayList<ShoppingCart> list) {
		try {
			shoppingCartServiceImpl.editShoppingCart(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 장바구니 삭제
	@DeleteMapping
	@ResponseBody
	public void deleteShoppingCart(ShoppingCart shoppingCart) {
		System.out.println(shoppingCart.getUser_id());
		try {
			shoppingCartServiceImpl.deleteShoppingCart(shoppingCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
