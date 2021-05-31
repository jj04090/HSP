package com.hsp.community;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
		Community result = null;
		try {
			result = communityMapper.select(community);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void registCommunity(Community community, MultipartFile attach) {
		try {
			String physicalName = this.imgUpload(attach);
			community.setMediafile(physicalName);
			communityMapper.insert(community);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCommunity(Community community, MultipartFile attach) {
		if (attach.isEmpty()) {
			try {
				communityMapper.update(community);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				String physicalName = this.imgUpload(attach);
				community.setMediafile(physicalName);
				communityMapper.update(community);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteCommunity(Community community) {
		// TODO Auto-generated method stub

	}

	@Override
	public String imgUpload(MultipartFile attach) {
		String savePath = "C:\\Users\\ws059\\project";//경로 변경해야함
		String logicalName = attach.getOriginalFilename();
		String physicalName = UUID.randomUUID().toString() + "_" + logicalName;
		
		try {
			attach.transferTo(new File(savePath + File.separator + physicalName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return physicalName;
	}

	@Override
	public ResponseEntity<Resource> display(String fileName) {
		String uploadPath = "C:\\Users\\ws059\\project\\";//경로 변경해야함
		Resource resource = new FileSystemResource(uploadPath + fileName);
		
		if (!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		Path filePath = null;
		
		try {
			filePath = Paths.get(uploadPath + fileName);
			header.add("Content-Type", Files.probeContentType(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
}