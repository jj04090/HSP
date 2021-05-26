package com.hsp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hsp")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/test/test");
		User user = new User();
		user.setUser_id("ADMIN");
		User result = null;
		try {
			result = userMapper.select(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelAndView;
	}
}
