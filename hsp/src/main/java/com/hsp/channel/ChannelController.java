package com.hsp.channel;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hsp.common.CommonServiceImpl;
import com.hsp.community.Community;
import com.hsp.community.CommunityServiceImpl;
import com.hsp.product.Product;
import com.hsp.product.ProductServiceImpl;
import com.hsp.user.User;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	private ChannelServiceImpl channelServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	CommonServiceImpl commonServiceImpl;
	@Autowired
	CommunityServiceImpl communityServiceImpl;
	@Autowired
	private HttpSession session;
	
	@GetMapping("") // 전체 채널 조회 (완료)
	public ModelAndView channel() {
		ModelAndView modelAndView = new ModelAndView();
		User getUser = (User)session.getAttribute("user");
		List<Channel> channelList = channelServiceImpl.viewChannelList();
		List<String> subsCount = commonServiceImpl.subsCount(channelList);
		List<String> checkSubs = channelServiceImpl.checkSubs(channelList, getUser.getUser_id());
		modelAndView.addObject("channelList", channelList);
		modelAndView.addObject("subs", subsCount);
		modelAndView.addObject("checkSubs", checkSubs);
		modelAndView.setViewName("/channel/channelList");
		return modelAndView;
	}
	
	@GetMapping("/{channel_id}") // 해당 채널 조회 (완료)
	public ModelAndView viewChannel(@PathVariable String channel_id) {
		ModelAndView modelAndView = new ModelAndView();
		Channel channel = new Channel();
		channel.setChannel_id(channel_id);
		List<Product> listProduct = productServiceImpl.channelProduct(channel_id);
		List<String> discountPrice = productServiceImpl.discountPrice(listProduct);
		channel = channelServiceImpl.viewChannel(channel);
		List<Community> commuList = communityServiceImpl.viewCommunityList(channel_id);
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("listProduct", listProduct);
		modelAndView.addObject("discountPrice", discountPrice);
		modelAndView.addObject("channel", channel);
		modelAndView.addObject("communityList", commuList);
		modelAndView.setViewName("/channel/channelView");
		return modelAndView;
	}
	
	@GetMapping("/regist") // 사업자 화면에서 채널 등록
	public ModelAndView registChannel() {
		ModelAndView modelAndView = new ModelAndView();
		String channel_id = "C" + UUID.randomUUID().toString().subSequence(0, 9);
//		User user = (User)session.getAttribute("user");
//		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("user_id", "U02"); // user_id 하드코딩
		modelAndView.setViewName("/channel/channelRegist");
		return modelAndView;
	}
	
	@PostMapping("") // 사업자 화면에서 채널 등록
	public ModelAndView regitProduct(Channel channel, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		channelServiceImpl.registChannel(channel, attach);
		modelAndView.setViewName("redirect:/main");
		return modelAndView;
	}
	
	@GetMapping("/{channel_id}/edit") // 사업자 화면에서 채널 수정
	public ModelAndView updateChannel(@PathVariable String channel_id) {
		ModelAndView modelAndView = new ModelAndView();
		Channel channel = new Channel();
		channel.setChannel_id(channel_id);
		channel = channelServiceImpl.viewChannel(channel);
		modelAndView.addObject("channel", channel);
		modelAndView.setViewName("/channel/channelEdit");
		return modelAndView;
	}
	
	@PutMapping("") // 사업자 화면에서 채널 수정 (중간)
	public ModelAndView updateChannel(@ModelAttribute Channel channel, MultipartFile attach) {
		ModelAndView mav = new ModelAndView(new RedirectView("/channel"));
		User getUser = (User)session.getAttribute("user");
		
		if(getUser.getUser_id() == channel.getUser_id()) {
			channelServiceImpl.updateChannel(channel, attach);
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
	
	@GetMapping("/subscribe/{channel_id}") // 채널 목록 조회 화면에서 구독 기능
	public ModelAndView registSubscribe(@PathVariable String channel_id) {
		ModelAndView modelAndView = new ModelAndView();
		User getUser = (User)session.getAttribute("user");
		Subscribe subscribe = new Subscribe();
		subscribe.setUser_id(getUser.getUser_id());
		subscribe.setChannel_id(channel_id);
		channelServiceImpl.startSubscribe(subscribe);
		modelAndView.setViewName("redirect:/channel");
		return modelAndView;
	}
	
	@DeleteMapping("/subscribe") // 구독 취소 기능
	public void deleteSubscribe() {
		User getUser = (User)session.getAttribute("user");
		Subscribe subscribe = new Subscribe();
		subscribe.setUser_id(getUser.getUser_id());
		
		channelServiceImpl.finishSubscribe(subscribe);
	}
	
	@GetMapping("/listsub") // 자신이 구독한 채널 목록
	public ModelAndView listSubscribe() {
		ModelAndView mav = new ModelAndView("/channel/subscribe");
		
		User getUser = (User)session.getAttribute("user");
		Subscribe subscribe = new Subscribe();
		subscribe.setUser_id(getUser.getUser_id());
		
		mav.addObject(channelServiceImpl.viewSubscribeList(subscribe));
		return mav;
	}
	
	@PostMapping("/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		channelServiceImpl.postCKEditorImgUpload(req, res, upload);
	}
	
	@GetMapping("/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return channelServiceImpl.display(fileName);
	}
}
