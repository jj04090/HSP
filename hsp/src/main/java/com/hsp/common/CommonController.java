package com.hsp.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hsp.channel.Channel;
import com.hsp.product.Product;
import com.hsp.user.User;
import com.hsp.user.UserServiceImpl;

@RestController
public class CommonController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	CommonServiceImpl commonServiceImpl;
	
	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		Product mostReviewProduct = commonServiceImpl.getMaxReview();
		Product mostOrderedproduct = commonServiceImpl.mostOrdered();
		List<Product> sellingList = commonServiceImpl.sellingList();
		List<Channel> topChannel = commonServiceImpl.channelList();
		
		modelAndView.addObject("grade", mostReviewProduct);
		modelAndView.addObject("ordered", mostOrderedproduct);
		modelAndView.addObject("sellingList", sellingList);
		modelAndView.addObject("topChannel", topChannel);
		modelAndView.setViewName("/main/main");
		
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/main/login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute User user) {
		String encryptPW = userServiceImpl.encryptPW(user.getPassword());
		user.setPassword(encryptPW);
		userServiceImpl.login(user);
		
		return new ModelAndView(new RedirectView("/main"));
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		userServiceImpl.logout();
		
		return new ModelAndView(new RedirectView("/main"));
	}
	
	@GetMapping("/find")
	public ModelAndView find() {
		return new ModelAndView("/main/find");
	}
	
	@PostMapping("/findID")
	public ModelAndView findID(@ModelAttribute User user) {
		userServiceImpl.findID(user);
		
		return new ModelAndView(new RedirectView("/login"));
	}

	@PostMapping("/findPW")
	public ModelAndView findPW(@ModelAttribute User user) {
		userServiceImpl.findPW(user);
		
		return new ModelAndView(new RedirectView("/login"));
	}
}
