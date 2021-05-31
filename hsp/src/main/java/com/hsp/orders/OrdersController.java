package com.hsp.orders;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	String channel_id = "";
//	String channel_id = "C01";
	String user_id = "ADMIN";
	
	@Autowired
	OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
	
	@PostMapping("") // 주문 등록 Json으로 값 들어옴 -> 예상 파라미터 (Order, List<String>) -> List<String> : Prodcut_id
	public ModelAndView orderRegit(String orderId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	@GetMapping("") // 주문 목록 조회	//사업자인 경우 팔린 주문 조회   //사용자인 경우 자신이 구매한 주문 목록 조회
	public ModelAndView orderList() {
		ModelAndView modelAndView = new ModelAndView();
		List<Orders> result = null;
		List<OrderDetail> bizSelect = null;
		if (!channel_id.isEmpty()) { // 사업자 접근 -> 채널 ID로 주문 상품 조회
			bizSelect = orderServiceImpl.viewSoldList(channel_id);
			modelAndView.addObject("ordersList", bizSelect);
			modelAndView.setViewName("/order/orderBizList");
		} else { // 사용자인 경우 -> User_id로 Order Table Select
			result = orderServiceImpl.viewOrderList(user_id);
			modelAndView.addObject("ordersList", result);
			modelAndView.setViewName("/order/orderList");
		}
		return modelAndView;
	}
	
	@GetMapping("/{order_id}") // 주문 상세 조회
	public ModelAndView orderView(@PathVariable(name = "order_id") String order_id) { 
		ModelAndView modelAndView = new ModelAndView();
		List<OrderInfo> orderInfo = null;
		if (!channel_id.isEmpty()) { // 사업자 접근
			orderInfo = orderServiceImpl.viewSoldDetail(order_id);
			modelAndView.addObject("orderInfo", orderInfo);
			modelAndView.addObject("auth", "B");
		} else { // 사용자 접근
			orderInfo = orderServiceImpl.viewOrder(user_id, order_id);
			modelAndView.addObject("orderInfo", orderInfo);
			modelAndView.addObject("auth", "C");
		}
		modelAndView.setViewName("/order/orderView");
		return modelAndView;
	}
	
	@GetMapping("/returnform") // 반품 신청 폼
	public ModelAndView orderReturn(@RequestParam(value = "order_id") String order_id, @RequestParam(value = "product_id") String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/order/returnFrom");
		modelAndView.addObject("order_id", order_id);
		modelAndView.addObject("product_id", product_id);
		return modelAndView;
	}
	
	@PostMapping("/return") // 반품 신청
	public ModelAndView orderReturn(Returns returns) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	@GetMapping("/return") // 신청된 반품 리스트 (세션에 채널ID 들어가있어야됨)
	public ModelAndView orderReturnList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	@GetMapping("/return/{returnId}") // 신청된 반품 상세 보기
	public ModelAndView orderReturnView(String returnId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	@GetMapping("/cancel/{order_id}")
	public ModelAndView orderCancel(@PathVariable String order_id) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	@GetMapping("/change/{orderStauts}")
	public ModelAndView orderStatusChange(String orderStatus) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("");
		return modelAndView;
	}
}
