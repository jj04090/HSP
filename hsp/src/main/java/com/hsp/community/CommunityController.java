package com.hsp.community;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.channel.Channel;
import com.hsp.product.Product;
import com.hsp.product.ProductServiceImpl;

@RestController
@RequestMapping("/community")
public class CommunityController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	CommunityServiceImpl communityServiceImpl;
	
	//게시글 목록 조회
	@GetMapping("/community")
	public ModelAndView listCommunity() {
		ModelAndView modelAndView = new ModelAndView();
		List<Community> listCommunity = communityServiceImpl.viewCommunityList();
		modelAndView.setViewName("/community/communityList");
		modelAndView.addObject("listCommunity", listCommunity);
		return modelAndView;
	}
	
	//게시글 상세 조회
	@GetMapping
	public ModelAndView viewCommunity(Channel channel) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/community/CommunityView");
		
		return mv;
	}
	
	//게시글 등록
	@PostMapping
	public void registCommunity(Community community) {
		
	}
	
	//게시글 수정
	@PutMapping
	public void editCommunity(Community community) {
		
	}
	
	//게시글 삭제
	@DeleteMapping
	public void deleteCommunity(Community community) {
		
	}
}
