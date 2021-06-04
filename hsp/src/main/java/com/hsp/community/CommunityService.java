package com.hsp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface CommunityService {
	public void registCommunity(Community community, MultipartFile attach);
	public void updateCommunity(Community community, MultipartFile attach);
	public void deleteCommunity(Community community);
	public List<Community> viewCommunityList(String channel_id);
	public Community viewCommunity(Community community);
	
	public String imgUpload(MultipartFile attach);
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload);
	public ResponseEntity<Resource> display(String fileName);
}