package com.hsp.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentMapper commentMapper;
	
	@Override
	public List<Comment> viewCommentList(String community_id) {
		Comment comment = new Comment();
		comment.setCommunity_id(community_id);
		List<Comment> listComment = null;
		try {
			listComment = commentMapper.list(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listComment;
	}
	
	@Override
	public Comment viewComment(Comment comment) {
		Comment result = null;
		try {
			result = commentMapper.select(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void registComment(Comment comment) {
		try {
			commentMapper.insert(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateComment(Comment comment) {
		try {
			commentMapper.update(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}