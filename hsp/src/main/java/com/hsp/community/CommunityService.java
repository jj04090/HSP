package com.hsp.community;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CommunityService {
	public void registCommunity(Community community, MultipartFile attach);
	public void updateCommunity(Community community, MultipartFile attach);
	public void deleteCommunity(Community community);
	public List<Community> viewCommunityList();
	public Community viewCommunity(Community community);
	
	public String imgUpload(MultipartFile attach);
	public ResponseEntity<Resource> display(String fileName);
}