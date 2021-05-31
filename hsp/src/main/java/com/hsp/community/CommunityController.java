package com.hsp.community;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hsp")
public class CommunityController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	CommunityServiceImpl communityServiceImpl;
	
	//테스트용
	String channel_id = "AAAAAAAA";
	
	//게시글 목록 조회
	@GetMapping("/community")
	public ModelAndView listCommunity() {
		ModelAndView modelAndView = new ModelAndView();
		List<Community> listCommunity = communityServiceImpl.viewCommunityList();
		modelAndView.setViewName("/community/communityList");
		modelAndView.addObject("listCommunity", listCommunity);
		return modelAndView;
	}
	
	//게시글 상세 조회
	@GetMapping("/community/{community_id}")
	public ModelAndView viewCommunity(@PathVariable(name = "community_id") String community_id) {
		Community community = new Community();
		community.setCommunity_id(community_id);
		Community result = communityServiceImpl.viewCommunity(community);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/community/communityView");
		modelAndView.addObject("community", result);
		return modelAndView;
	}
	
	//게시글 수정 폼
	@GetMapping("/community/{community_id}/editform")
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
	@GetMapping("/community/registform")
	public ModelAndView regitCommunity() {
		ModelAndView modelAndView = new ModelAndView();
		String community_id = "C" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/community/communityRegist");
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("community_id", community_id);
		return modelAndView;
	}
	
	//게시글 등록
	@PostMapping("/community")
	public ModelAndView regitCommunity(Community community, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		communityServiceImpl.registCommunity(community, attach);
		modelAndView.setViewName("redirect:/hsp/community");
		return modelAndView;
	}
	
	//게시글 수정
	@PostMapping("/communityupdate")
	public ModelAndView updateCommunity(Community community, MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		communityServiceImpl.updateCommunity(community, attach);
		modelAndView.setViewName("redirect:/hsp/community/" + community.getCommunity_id());
		return modelAndView;
	}
	
	//게시글 삭제
	@DeleteMapping("/community")
	public ModelAndView deleteCommunity(Community community) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
	
	//사진업로드
	@PostMapping("/community/ckUpload")
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
			String fileUrl = "/hsp/community/display?filename=" + uid + "_" + fileName;  // 작성화면
			
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
	
	@GetMapping("/community/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return communityServiceImpl.display(fileName);
	}
}
