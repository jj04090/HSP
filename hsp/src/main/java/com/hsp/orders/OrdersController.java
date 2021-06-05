package com.hsp.orders;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.user.User;

@RestController
@RequestMapping("/order")
public class OrdersController {
	
	@Autowired
	HttpSession httpSession;
	
	String channel_id = "";
//	String channel_id = "C01";
//	String user_id = "ADMIN";
	
	@Autowired
	OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
	
	@PostMapping("") // 주문 등록 Json으로 값 들어옴 -> 예상 파라미터 (Order, List<String>) -> List<String> : Prodcut_id
	@ResponseBody
	public ModelAndView orderRegit(Orders orders, String cartType) {
		System.out.println(orders.getOrder_id()+orders.getUser_id()+"/////////////////"+cartType);
		ModelAndView modelAndView = new ModelAndView();
		orderServiceImpl.applyOrder(orders, cartType);
		modelAndView.setViewName("redirect:/order");
		return modelAndView;
	}
	
	@GetMapping("") // 주문 목록 조회	//사업자인 경우 팔린 주문 조회   //사용자인 경우 자신이 구매한 주문 목록 조회
	public ModelAndView orderList(String log) {
		User getUser = (User)httpSession.getAttribute("user");
		System.out.println(log);
		ModelAndView modelAndView = new ModelAndView();
		List<Orders> result = null;
		List<Orders> bizSelect = null;
		
		if (!channel_id.isEmpty()) { // 사업자 접근 -> 채널 ID로 주문 상품 조회
			bizSelect = orderServiceImpl.viewSoldList(channel_id);
			modelAndView.addObject("ordersList", bizSelect);
			modelAndView.addObject("user_type", "B");
			modelAndView.setViewName("/order/orderBizList");
			
		} else { // 사용자인 경우 -> User_id로 Order Table Select
			result = orderServiceImpl.viewOrderList(getUser.getUser_id());
			List<String> cancelAble = orderServiceImpl.getStatus(result);
			modelAndView.addObject("user_type", "C");
			modelAndView.addObject("ordersList", result);
			modelAndView.addObject("cancelAble", cancelAble);
			modelAndView.setViewName("/order/orderList");
		}
		
		return modelAndView;
	}
	
	@GetMapping("/{order_id}") // 주문 상세 조회
	public ModelAndView orderView(@PathVariable(name = "order_id") String order_id) { 
		User getUser = (User)httpSession.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		
		if (!channel_id.isEmpty()) { // 사업자 접근
			List<OrderInfo> orderInfo = orderServiceImpl.viewSold(order_id, channel_id);
			modelAndView.addObject("orderInfoList", orderInfo);
			modelAndView.setViewName("/order/orderBizView");
		} else {
			List<OrderInfo> orderInfo = orderServiceImpl.viewOrder(getUser.getUser_id(), order_id);
			modelAndView.addObject("orderInfo", orderInfo);
			modelAndView.setViewName("/order/orderView");
		}
		
		return modelAndView;
	}
	
//	@GetMapping("/{order_id}/{product_id}") // 사업자 주문 상세 조회
//	public ModelAndView soldView(@PathVariable(name = "order_id") String order_id, @PathVariable(name = "product_id") String product_id) {
//		ModelAndView modelAndView = new ModelAndView();
//		OrderInfo orderInfo = orderServiceImpl.viewSold(order_id, product_id);
//		modelAndView.addObject("orderInfo", orderInfo);
//		modelAndView.setViewName("/order/orderBizView");
//		return modelAndView;
//	}
	
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
		orderServiceImpl.applyReturn(returns);
		modelAndView.setViewName("redirect:/order");
		return modelAndView;
	}
	
	@GetMapping("/return") // 신청된 반품 리스트 (세션에 채널ID 들어가있어야됨) // 사업자만
	public ModelAndView orderReturnList() {
		ModelAndView modelAndView = new ModelAndView();
		List<Returns> returnsList = orderServiceImpl.viewReturnList(channel_id);
		modelAndView.addObject("returnsList", returnsList);
		modelAndView.setViewName("/order/returnList");
		return modelAndView;
	}
	
	@GetMapping("/return/{return_id}") // 신청된 반품 상세 보기 // 사업자만
	public ModelAndView orderReturnView(@PathVariable String return_id) {
		ModelAndView modelAndView = new ModelAndView();
		Returns returnView = orderServiceImpl.viewReturn(return_id);
		modelAndView.addObject("returns", returnView);
		modelAndView.setViewName("/order/returnView");
		return modelAndView;
	}
	
	@GetMapping("/cancel/{order_id}")
	public ModelAndView orderCancel(@PathVariable String order_id) {
		ModelAndView modelAndView = new ModelAndView();
		String result = orderServiceImpl.cancelOrder(order_id);
		modelAndView.setViewName("redirect:/order");
		modelAndView.addObject("log", result); // 처리 메시지는 어떻게 할건지 나중에 논의
		return modelAndView;
	}
	
	@GetMapping("/cancelschedual/{order_id}") // new // 정기 주문 취소
	public ModelAndView cancelschedual(@PathVariable String order_id) {
		ModelAndView modelAndView = new ModelAndView();
		orderServiceImpl.cancelSchedual(order_id);
		modelAndView.setViewName("redirect:/order");
		return modelAndView;
	}
	
	@PutMapping("/change") // 요청방식 변경 GET -> PUT
	public ModelAndView orderStatusChange(String order_id, String product_id, String delevery_status) {
		ModelAndView modelAndView = new ModelAndView();
		orderServiceImpl.changeStatus(order_id, product_id, delevery_status);
		modelAndView.setViewName("redirect:/order");
		return modelAndView;
	}
}
