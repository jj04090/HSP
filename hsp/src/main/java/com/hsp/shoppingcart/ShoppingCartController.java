package com.hsp.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hsp.orders.Orders;
import com.hsp.payment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.hsp.payment.PaymentService;
import com.hsp.product.Product;
import com.hsp.product.ProductServiceImpl;
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
	
	// 장바구니 조회
	@GetMapping("/{cartType}")
	public ModelAndView viewShoppingCart(@PathVariable String cartType) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/shoppingcart/shoppingCartList");
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCart_type(cartType);
		shoppingCart.setUser_id("a"); //세션에서 가져오기
		
		try {
			List<ShoppingCart> shoppingList = new ArrayList<ShoppingCart>();
			
			shoppingList = shoppingCartServiceImpl.viewShoppingCart(shoppingCart);
			
			mv.addObject("shoppingList", shoppingList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	/*
	 * @GetMapping public ModelAndView viewShoppingCart(User user) { ModelAndView mv
	 * = new ModelAndView();
	 * mv.setViewName("redirect:/testapi.openbanking.or.kr/v2.0/authorize");
	 * 
	 * return mv; }
	 */

	/*
	 * // 장바구니 등록
	 * 
	 * @PostMapping
	 * 
	 * @ResponseBody public String registShoppingCart(Orders orders) { try {
	 * System.out.println(orders.getOrder_id());
	 * paymentServiceImpl.cancelPayment(orders.getOrder_id()); } catch (Exception e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } return "ddddd"; }
	 */
	
	// 장바구니 등록
		@PostMapping
		@ResponseBody
		public void registShoppingCart(Orders orders) {
			
		}

	// 장바구니 수정
	@PutMapping
	public ModelAndView updateShoppingCart() {
		ModelAndView mv = new ModelAndView(new RedirectView("/hsp/main"));

		return mv;
	}

	// 장바구니 삭제
	@DeleteMapping
	public void deleteShoppingCart(ShoppingCart shoppingCart) {

	}
}
