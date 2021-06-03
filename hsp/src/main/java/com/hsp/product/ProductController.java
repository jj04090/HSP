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
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	String channel_id = "C01";

	@GetMapping("")
	public ModelAndView listProduct() {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> listProduct = productServiceImpl.viewProductList();
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("listProduct", listProduct);
		modelAndView.setViewName("/product/productAll");
		return modelAndView;
	}
	
	@GetMapping("/{channel_id}")
	public ModelAndView channelProduct(@PathVariable String channel_id) {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> listProduct = productServiceImpl.channelProduct(channel_id);
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("listProduct", listProduct);
		modelAndView.setViewName("/product/productList");
		return modelAndView;
	}
	
	@GetMapping("/{channel_id}/{product_id}")
	public ModelAndView viewProduct(@PathVariable String channel_id, @PathVariable String product_id) {
		Product product = new Product();
		product.setProduct_id(product_id);
		product.setChannel_id(channel_id);
		Product result = productServiceImpl.viewProduct(product);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/product/productView");
		modelAndView.addObject("product", result);
		return modelAndView;
	}
	
	@GetMapping("/{product_id}/editform")
	public ModelAndView updateProduct(@PathVariable(name = "product_id") String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		product.setProduct_id(product_id);
		Product result = productServiceImpl.viewProduct(product);
		modelAndView.setViewName("/product/productEditForm");
		modelAndView.addObject("product", result);
		return modelAndView;
	}
	
	@GetMapping("/registform")
	public ModelAndView regitProduct() {
		ModelAndView modelAndView = new ModelAndView();
		String product_id = "P" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/product/productRegist");
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("product_id", product_id);
		return modelAndView;
	}

	@PostMapping("")
	public ModelAndView regitProduct(Product product, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		productServiceImpl.registProduct(product, attach);
		modelAndView.setViewName("redirect:/product");
		return modelAndView;
	}
	
	@PutMapping("")
	public ModelAndView updateProduct(Product product, MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		productServiceImpl.updateProduct(product, attach);
		modelAndView.setViewName("redirect:/product/" + product.getProduct_id());
		return modelAndView;
	}
	
	@DeleteMapping("")
	public ModelAndView deleteProduct(Product product) {
		ModelAndView modelAndView = null;
		//나중에
		return modelAndView;
	}
	
	@PostMapping("/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		productServiceImpl.postCKEditorImgUpload(req, res, upload);
	}
	
	@GetMapping("/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return productServiceImpl.display(fileName);
	}

}
