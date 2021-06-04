package com.hsp.channel;

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

import com.hsp.user.User;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	private ChannelServiceImpl channelServiceImpl;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping
	public ModelAndView channel() {
		return new ModelAndView("/channel/channel");
	}
	
	@GetMapping("/{channel_id}")
	public ModelAndView viewChannel(@PathVariable String channel_id) {
		ModelAndView mav = new ModelAndView("/channel/viewChannel");
					
		Channel channel = new Channel();
		channel.setChannel_id(channel_id);
		mav.addObject("channel", channelServiceImpl.viewChannel(channel));
		
		session.setAttribute("channel", channelServiceImpl.viewChannel(channel));
		return mav;
	}
	
	@GetMapping("/regist")
	public ModelAndView registChannel() {
		return new ModelAndView("/channel/registChannel");
	}
	
	@PostMapping
	public ModelAndView registChannel(@ModelAttribute Channel channel) {
		ModelAndView mav = new ModelAndView(new RedirectView("/channel"));
		channelServiceImpl.registChannel(channel);
		
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView updateChannel() {
		return new ModelAndView("/channel/updateChannel");
	}
	
	@PutMapping
	public ModelAndView updateChannel(@ModelAttribute Channel channel) {
		ModelAndView mav = new ModelAndView(new RedirectView("/channel"));
		User getUser = (User)session.getAttribute("user");
		
		if(getUser.getUser_id() == channel.getUser_id()) {
			channelServiceImpl.updateChannel(channel);
		}
		return mav;
	}
	
	@DeleteMapping
	public ModelAndView deleteChannel() {
		ModelAndView mav = new ModelAndView(new RedirectView("/channel"));
		
		Channel getChannel = (Channel)session.getAttribute("channel");
		channelServiceImpl.deleteChannel(getChannel);
		session.removeAttribute("channel");
		
		return mav;
	}
	
	@PostMapping("/subscribe")
	public void registSubscribe() {
		User getUser = (User)session.getAttribute("user");
		Subscribe subscribe = new Subscribe();
		subscribe.setUser_id(getUser.getUser_id());
		
		channelServiceImpl.startSubscribe(subscribe);
	}
	
	@DeleteMapping("/subscribe")
	public void deleteSubscribe() {
		User getUser = (User)session.getAttribute("user");
		Subscribe subscribe = new Subscribe();
		subscribe.setUser_id(getUser.getUser_id());
		
		channelServiceImpl.finishSubscribe(subscribe);
	}
	
	@GetMapping("/listsub")
	public ModelAndView listSubscribe() {
		ModelAndView mav = new ModelAndView("/channel/subscribe");
		
		User getUser = (User)session.getAttribute("user");
		Subscribe subscribe = new Subscribe();
		subscribe.setUser_id(getUser.getUser_id());
		
		mav.addObject(channelServiceImpl.viewSubscribeList(subscribe));
		return mav;
	}
	
}
