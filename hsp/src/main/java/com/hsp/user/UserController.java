package com.hsp.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping
	public ModelAndView user() {
		ModelAndView mav = new ModelAndView();
		
		User getUser = (User)session.getAttribute("user");
		mav.setView(new RedirectView("/user/" + getUser.getUser_id()));
		
		return mav;
	}
	
	@GetMapping("/{user_id}")
	public ModelAndView viewUser(@PathVariable String user_id) {
		ModelAndView mav = new ModelAndView("/user/user");
		
		User user = new User();
		user.setUser_id(user_id);
		mav.addObject("user", userServiceImpl.viewUser(user));
		
		return mav;
	}
	
	@GetMapping("/regist")
	public ModelAndView registUser() {
		return new ModelAndView("/user/registUser");
	}
	
	@PostMapping
	public ModelAndView registUser(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView(new RedirectView("/login"));
		
		String encryptPW = userServiceImpl.encryptPW(user.getPassword());
		user.setPassword(encryptPW);
		userServiceImpl.registUser(user);
		
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView updateUser() {
		return new ModelAndView("/user/updateUser");
	}
	
	@PutMapping
	public ModelAndView updateUser(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView(new RedirectView("/user"));

		userServiceImpl.updateUser(user);
		session.invalidate();
		session.setAttribute("user", userServiceImpl.viewUser(user));
		
		return mav;
	}
	
	@DeleteMapping
	public ModelAndView deleteUser() {
		ModelAndView mav = new ModelAndView(new RedirectView("/main"));
		
		User getUser = (User)session.getAttribute("user");
		userServiceImpl.deleteUser(getUser);
		session.invalidate();
		
		return mav;
	}

}
