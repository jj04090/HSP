package com.hsp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hsp")
public class ProductController {
	
	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
}
