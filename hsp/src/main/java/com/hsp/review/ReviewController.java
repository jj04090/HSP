package com.hsp.review;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	
	//테스트용
	String product_id = "P01";
	
	//리뷰 목록 조회
	@GetMapping("/review")
	public ModelAndView listReview() {
		ModelAndView modelAndView = new ModelAndView();
		List<Review> listreview = reviewServiceImpl.viewReviewList();
		modelAndView.setViewName("/review/reviewList");
		modelAndView.addObject("listreview", listreview);
		return modelAndView;
	}
	
	//리뷰 상세 조회
	@GetMapping("/review/{review_id}")
	public ModelAndView viewreview(@PathVariable(name = "review_id") String review_id) {
		Review review = new Review();
		review.setReview_id(review_id);
		Review result = reviewServiceImpl.viewReview(review);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/review/reviewView");
		modelAndView.addObject("review", result);
		return modelAndView;
	}
	
	//리뷰 수정 폼
	@GetMapping("/review/{review_id}/editform")
	public ModelAndView updatereview(@PathVariable(name = "review_id") String review_id) {
		ModelAndView modelAndView = new ModelAndView();
		Review review = new Review();
		review.setReview_id(review_id);
		Review result = reviewServiceImpl.viewReview(review);
		modelAndView.setViewName("/review/reviewEditForm");
		modelAndView.addObject("review", result);
		return modelAndView;
	}
	
	//리뷰 등록 폼
	@GetMapping("/review/registform")
	public ModelAndView regitReview() {
		ModelAndView modelAndView = new ModelAndView();
		String review_id = "R" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/review/reviewRegist");
		modelAndView.addObject("product_id", product_id);
		modelAndView.addObject("review_id", review_id);
		return modelAndView;
	}
	
	//리뷰 등록
	@PostMapping("/review")
	public ModelAndView regitReview(Review review, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		reviewServiceImpl.registReview(review, attach);
		modelAndView.setViewName("redirect:/hsp/review");
		return modelAndView;
	}
	
	//리뷰 수정
	@PostMapping("/reviewupdate")
	public ModelAndView updateReview(Review review, MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		reviewServiceImpl.updateReview(review, attach);
		modelAndView.setViewName("redirect:/hsp/review/" + review.getReview_id());
		return modelAndView;
	}
	
	//리뷰 삭제
	@DeleteMapping("/review")
	public ModelAndView deleteReview(Review review) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
	
	//사진업로드
	@PostMapping("/review/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		String uploadPath = "C:\\Users\\ws059\\project"; // 기본 경로
		// 랜덤 문자 생성
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
				
		// 인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			
			String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
			byte[] bytes = upload.getBytes();
			
			// 업로드 경로
			String ckUploadPath = uploadPath + File.separator + uid + "_" + fileName;
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();  // out에 저장된 데이터를 전송하고 초기화
			
			printWriter = res.getWriter();
			String fileUrl = "/hsp/review/display?filename=" + uid + "_" + fileName;  // 작성화면
			
			// 업로드시 메시지 출력
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			
			printWriter.flush();
			
		} catch (IOException e) { e.printStackTrace();
		} finally {
			try {
				if(out != null) { out.close(); }
				if(printWriter != null) { printWriter.close(); }
			} catch(IOException e) { e.printStackTrace(); }
		} 
		
		return;	
	}
	
	@GetMapping("/review/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return reviewServiceImpl.display(fileName);
	}
}
