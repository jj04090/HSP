package com.hsp.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hsp")
public class OrdersController {
	
	@Autowired
	private OrdersMapper orderMapper;
	
	@GetMapping("/order")
	public ModelAndView main() {
		ModelAndView modelAndView = null;
		try {
//			Order order = new Order();
//			order.setOrder_id("O01");
			List<Orders> result = orderMapper.list();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
}
