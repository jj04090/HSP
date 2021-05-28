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
	
	@GetMapping("/order")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("");
		return modelAndView;
	}
}
