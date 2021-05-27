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

	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
	
	
}
