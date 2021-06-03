package com.hsp.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@RestController
@RequestMapping("/community")
public class CommunityController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	CommunityServiceImpl communityServiceImpl;
	
	String channel_id = "C01";
	
	//게시글 목록 조회
	@GetMapping("/{channel_id}")
	public ModelAndView listCommunity(@PathVariable String channel_id) {
		ModelAndView modelAndView = new ModelAndView();
		List<Community> listCommunity = communityServiceImpl.viewCommunityList(channel_id);
		modelAndView.setViewName("/community/communityList");
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("listCommunity", listCommunity);
		return modelAndView;
	}
	
	//게시글 상세 조회
	@GetMapping("/{channel_id}/{community_id}")
	public ModelAndView viewCommunity(@PathVariable String channel_id, @PathVariable String community_id) {
		Community community = new Community();
		community.setChannel_id(channel_id);
		community.setCommunity_id(community_id);
		Community result = communityServiceImpl.viewCommunity(community);
		
		List<Comment> listComment = communityServiceImpl.viewCommentList(community_id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/community/communityView");
		modelAndView.addObject("community", result);
		modelAndView.addObject("listComment", listComment);
		return modelAndView;
	}
	
	//게시글 수정 폼
	@GetMapping("/{community_id}/editform")
	public ModelAndView updateCommunity(@PathVariable(name = "community_id") String community_id) {
		ModelAndView modelAndView = new ModelAndView();
		Community community = new Community();
		community.setCommunity_id(community_id);
		Community result = communityServiceImpl.viewCommunity(community);
		modelAndView.setViewName("/community/communityEditForm");
		modelAndView.addObject("community", result);
		return modelAndView;
	}
	
	//게시글 등록 폼
	@GetMapping("/registform")
	public ModelAndView regitCommunity() {
		ModelAndView modelAndView = new ModelAndView();
		String community_id = "COMMU" + UUID.randomUUID().toString().subSequence(0, 5);
		modelAndView.setViewName("/community/communityRegist");
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String regit_date = format1.format(date);
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("community_id", community_id);
		modelAndView.addObject("regit_date", regit_date);
		return modelAndView;
	}
	
	//게시글 등록
	@PostMapping("")
	public ModelAndView regitCommunity(@ModelAttribute Community community, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		communityServiceImpl.registCommunity(community, attach);
		modelAndView.setViewName("redirect:/community/" + community.getChannel_id());
		return modelAndView;
	}
	
	//게시글 수정
	@PutMapping("")
	public ModelAndView updateCommunity(Community community, MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		communityServiceImpl.updateCommunity(community, attach);
		modelAndView.setViewName("redirect:/community/" + community.getCommunity_id());
		return modelAndView;
	}
	
	//게시글 삭제
	@DeleteMapping("")
	public ModelAndView deleteCommunity(Community community) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
	
	//사진업로드
	@PostMapping("/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		communityServiceImpl.postCKEditorImgUpload(req, res, upload);
	}
	
	@GetMapping("/community/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return communityServiceImpl.display(fileName);
	}
}
