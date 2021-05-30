package com.hsp.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	private ChannelServiceImpl channelServiceImpl;
	
	@GetMapping
	public ModelAndView channelList(Channel channel) {
		/*



		*/
		return new ModelAndView();
	}
	
	@PostMapping
	public ModelAndView channelRegit(Channel channel) {
		/*



		*/
		return new ModelAndView();
	}
	
	@PutMapping
	public ModelAndView channelEdit(Channel channel) {
		/*



		*/
		return new ModelAndView();
	}
	
	@DeleteMapping
	public ModelAndView channelDelete(Channel channel) {
		/*



		*/
		return new ModelAndView();
	}
	
	@PostMapping("/subscribe")
	public ModelAndView subscribeApply(Subscribe subscribe) {
		/*



		*/
		return new ModelAndView();
	}
	
	@DeleteMapping("/subscribe")
	public ModelAndView subscribeCancel(Subscribe subscribe) {
		/*



		*/
		return new ModelAndView();
	}
	
}
