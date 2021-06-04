package com.hsp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface CommentService {
	public List<Comment> viewCommentList(String community_id);
	public void registComment(Comment comment);
	public void updateComment(Comment comment);
	public Comment viewComment(Comment comment);
}