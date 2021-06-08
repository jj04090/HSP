package com.hsp.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

import com.hsp.channel.Subscribe;
import com.hsp.channel.SubscribeMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	@Autowired
	SubscribeMapper subscribeMapper;

	@Override
	public List<Product> viewProductList() {
		Product product = new Product();
		List<Product> listProduct = null;
		
		try {
			listProduct = productMapper.list(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listProduct;
	}
	
	@Override
	public String subsCheck(Product product, String user_id) {
		String msg = "X";
		Subscribe subs = new Subscribe();
		subs.setUser_id(user_id);
		
		try {
			List<Subscribe> subsList = subscribeMapper.list(subs);
			for (Subscribe subsCheck : subsList) {
				if (subsCheck.getChannel_id().equals(product.getChannel_id())) {
					msg = "O";
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	@Override
	public List<String> discountPrice(List<Product> productList) {
		List<String> discountList = new ArrayList<String>();
		
		for (Product product : productList) {
			int price = Integer.parseInt(product.getProduct_price());
			float discount = Integer.parseInt(product.getDiscount());
			double discountPrice = price * ( discount / 100 );
			double total = price - discountPrice;
			total = total * 1;
			
			discountList.add(String.valueOf((int)total));
		}
		
		
		return discountList;
	}
	
	@Override
	public String singleDiscount(Product product) {
		int price = Integer.parseInt(product.getProduct_price());
		float discount = Integer.parseInt(product.getDiscount());
		double discountPrice = price * ( discount / 100 );
		double total = price - discountPrice;
		total = total * 1;
		
		return String.valueOf((int)total);
	}
	
	@Override
	public List<Product> channelProduct(String channel_id) {
		List<Product> productList = null;
		Product product = new Product();
		product.setChannel_id(channel_id);
		
		try {
			productList = productMapper.list(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public Product viewProduct(Product product) {
		Product result = null;
		
		try {
			result = productMapper.select(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void registProduct(Product product, MultipartFile attach) {
		try {
			String physicalName = this.imgUpload(attach);
			product.setProduct_img(physicalName);
			productMapper.insert(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateProduct(Product product, MultipartFile attach) {
		if (attach.isEmpty()) {
			try {
				productMapper.update(product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				String physicalName = this.imgUpload(attach);
				product.setProduct_img(physicalName);
				productMapper.update(product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public String imgUpload(MultipartFile attach) {
		String savePath = "C:\\Users\\ws059\\project";
		
//		String uploadPath = req.getSession().getServletContext().getRealPath("/").concat("resources");
//		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		
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
		String uploadPath = "C:\\Users\\ws059\\project\\";
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

	@Override
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, MultipartFile upload) {
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
			String fileUrl = "/product/display?filename=" + uid + "_" + fileName;  // 작성화면
			
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

	

}