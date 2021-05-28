package com.hsp.product;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpSession;

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
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> viewProductList() {
		List<Product> listProduct = null;
		try {
			listProduct = productMapper.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
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
}