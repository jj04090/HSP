package com.hsp.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	CommunityMapper communityMapper;
	
	@Override
	public List<Community> viewCommunityList() {
		List<Community> listCommunity = null;
		try {
			listCommunity = communityMapper.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCommunity;
	}
	
	@Override
	public Community viewCommunity(Community community) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommunity(Community community) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registCommunity(Community community, MultipartFile attach) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCommunity(Community community, MultipartFile attach) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String imgUpload(MultipartFile attach) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> display(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
}