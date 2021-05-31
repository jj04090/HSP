package com.hsp.review;

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
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewMapper reviewMapper;
	
	@Override
	public List<Review> viewReviewList() {
		List<Review> listreview = null;
		try {
			listreview = reviewMapper.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listreview;
	}
	
	@Override
	public Review viewReview(Review review) {
		Review result = null;
		try {
			result = reviewMapper.select(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void registReview(Review review, MultipartFile attach) {
		try {
			String physicalName = this.imgUpload(attach);
			review.setReview_img(physicalName);
			reviewMapper.insert(review);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateReview(Review review, MultipartFile attach) {
		if (attach.isEmpty()) {
			try {
				reviewMapper.update(review);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				String physicalName = this.imgUpload(attach);
				review.setReview_img(physicalName);
				reviewMapper.update(review);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteReview(Review review) {
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