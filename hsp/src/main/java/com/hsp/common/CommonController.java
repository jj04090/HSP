package com.hsp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hsp.user.User;
import com.hsp.user.UserServiceImpl;

@RestController
public class CommonController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/main")
	public ModelAndView main() {
		return new ModelAndView("/main");
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute User user) {
		userServiceImpl.login(user);
		
		return new ModelAndView(new RedirectView("/main"));
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		userServiceImpl.logout();
		
		return new ModelAndView(new RedirectView("/main"));
	}
	
	@GetMapping("/findID")
	public ModelAndView findID() {
		return new ModelAndView("/findID");
	}
	
	@PostMapping("/findID")
	public ModelAndView findID(@ModelAttribute User user) {
		userServiceImpl.findID(user);
		
		return new ModelAndView(new RedirectView("/main"));
	}
	
	@GetMapping("/findPW")
	public ModelAndView findPW() {
		return new ModelAndView("/findPW");
	}
	
	@PostMapping("/findPW")
	public ModelAndView findPW(@ModelAttribute User user) {
		userServiceImpl.findPW(user);
		
		return new ModelAndView(new RedirectView("/main"));
	}
}
