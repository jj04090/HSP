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
public class CommentController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	CommentServiceImpl commentServiceImpl;
	
	String channel_id = "C01";
	String community_id = "COMMU01";
	String user_id = "U02";
	
	//댓글 수정 폼
	@GetMapping("/{community_id}/{comment_id}/editform")
	public ModelAndView updateComment(@PathVariable String comment_id) {
		ModelAndView modelAndView = new ModelAndView();
		Comment comment = new Comment();
		comment.setComment_id(comment_id);
		comment.setUser_id(user_id);
		Comment result = commentServiceImpl.viewComment(comment);
		modelAndView.setViewName("/community/commentEditForm");
		modelAndView.addObject("comment", result);
		return modelAndView;
	}
	
	//댓글 등록 폼
	@GetMapping("/commeregistform")
	public ModelAndView regitComment() {
		ModelAndView modelAndView = new ModelAndView();
		String comment_id = "COMME" + UUID.randomUUID().toString().subSequence(0, 5);
		modelAndView.setViewName("/community/commentRegist");
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String regit_date = format1.format(date);
		modelAndView.addObject("comment_id", comment_id);
		modelAndView.addObject("community_id", community_id);
		modelAndView.addObject("user_id", user_id);
		modelAndView.addObject("regit_date", regit_date);
		return modelAndView;
	}
	
	//댓글 등록
	@PostMapping("/comme")
	public ModelAndView regitComment(Comment comment) {
		ModelAndView modelAndView = new ModelAndView();
		commentServiceImpl.registComment(comment);
		modelAndView.setViewName("redirect:/community/" + channel_id + "/" + comment.getCommunity_id());
		return modelAndView;
	}

	//댓글 수정
	@PutMapping("/comme")
	public ModelAndView updateComment(Comment comment) {
		ModelAndView modelAndView = new ModelAndView();
		commentServiceImpl.updateComment(comment);
		modelAndView.setViewName("redirect:/community/" + channel_id + "/" + comment.getCommunity_id());
		return modelAndView;
	}
}
