package com.hsp.product;

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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hsp")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	String channel_id = "C01";

	@GetMapping("/product")
	public ModelAndView listProduct() {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> listProduct = productServiceImpl.viewProductList();
		modelAndView.setViewName("/product/productList");
		modelAndView.addObject("listProduct", listProduct);
		return modelAndView;
	}
	
	@GetMapping("/product/{product_id}")
	public ModelAndView viewProduct(@PathVariable(name = "product_id") String product_id) {
		Product product = new Product();
		product.setProduct_id(product_id);
		Product result = productServiceImpl.viewProduct(product);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/product/productView");
		modelAndView.addObject("product", result);
		return modelAndView;
	}
	
	@GetMapping("/product/{product_id}/editform")
	public ModelAndView updateProduct(@PathVariable(name = "product_id") String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		product.setProduct_id(product_id);
		Product result = productServiceImpl.viewProduct(product);
		modelAndView.setViewName("/product/productEditForm");
		modelAndView.addObject("product", result);
		return modelAndView;
	}
	
	@GetMapping("/product/registform")
	public ModelAndView regitProduct() {
		ModelAndView modelAndView = new ModelAndView();
		String product_id = "P" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/product/productRegist");
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("product_id", product_id);
		return modelAndView;
	}

	@PostMapping("/product")
	public ModelAndView regitProduct(Product product, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		productServiceImpl.registProduct(product, attach);
		modelAndView.setViewName("redirect:/hsp/product");
		return modelAndView;
	}
	
	@PostMapping("/productupdate")
	public ModelAndView updateProduct(Product product, MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		productServiceImpl.updateProduct(product, attach);
		modelAndView.setViewName("redirect:/hsp/product/" + product.getProduct_id());
		return modelAndView;
	}
	
	@DeleteMapping("/product")
	public ModelAndView deleteProduct(Product product) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
	
	@PostMapping("/product/ckUpload")
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
//			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName; //origin
			String ckUploadPath = uploadPath + File.separator + uid + "_" + fileName;
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();  // out에 저장된 데이터를 전송하고 초기화
			
			printWriter = res.getWriter();
			String fileUrl = "/hsp/product/display?filename=" + uid + "_" + fileName;  // 작성화면
			
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
	
	@GetMapping("/product/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return productServiceImpl.display(fileName);
	}

}
