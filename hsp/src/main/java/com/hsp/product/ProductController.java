package com.hsp.product;

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

import com.hsp.channel.Channel;
import com.hsp.channel.ChannelServiceImpl;
import com.hsp.inquiry.Inquiry;
import com.hsp.inquiry.InquiryServiceImpl;
import com.hsp.review.Review;
import com.hsp.review.ReviewServiceImpl;
import com.hsp.user.User;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	ChannelServiceImpl channelServiceImpl;
	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	@Autowired
	InquiryServiceImpl inquiryServiceImpl;
	@Autowired
	HttpSession httpSession;
	

	@GetMapping("")
	public ModelAndView listProduct() {
		ModelAndView modelAndView = new ModelAndView();
		User getUser = (User)httpSession.getAttribute("user");
		String channel_id = (String)httpSession.getAttribute("channel_id");
	
		if (!channel_id.isEmpty()) { // 사업자
			Channel channel = new Channel();
			channel.setChannel_id(channel_id);
			List<Product> listProduct = productServiceImpl.channelProduct(channel_id);
			List<String> discountPrice = productServiceImpl.discountPrice(listProduct);
			channel = channelServiceImpl.viewChannel(channel);
			modelAndView.addObject("channel_id", channel_id);
			modelAndView.addObject("listProduct", listProduct);
			modelAndView.addObject("discountPrice", discountPrice);
			modelAndView.setViewName("/product/productListBiz");
		} else {
			List<Product> listProduct = productServiceImpl.viewProductList();
			List<String> discountPrice = productServiceImpl.discountPrice(listProduct);
			modelAndView.addObject("channel_id", channel_id);
			modelAndView.addObject("listProduct", listProduct);
			modelAndView.addObject("discountPrice", discountPrice);
			modelAndView.setViewName("/product/productAll");
		}
		
		return modelAndView;
	}
	
	@GetMapping("/{channel_id}/{product_id}")
	public ModelAndView viewProduct(@PathVariable String channel_id, @PathVariable String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		User getUser = (User)httpSession.getAttribute("user");
		String checkChannel = (String)httpSession.getAttribute("channel_id");
		
		Product product = new Product();
		product.setProduct_id(product_id);
		product.setChannel_id(channel_id);
		Product result = productServiceImpl.viewProduct(product);
		String discount = productServiceImpl.singleDiscount(result);
		String subsCheck = productServiceImpl.subsCheck(result, getUser.getUser_id());
		Review review = new Review();
		review.setProduct_id(product_id);
		List<Review> reviewList = reviewServiceImpl.viewReviewList(product_id); // product_id
		List<Inquiry> inquiryList = inquiryServiceImpl.viewInquiryList(product_id); // product_id
		Channel channel = new Channel();
		channel.setChannel_id(result.getChannel_id()); 
		String checkSubs = channelServiceImpl.singleCheckSubs(channel, getUser.getUser_id());
		modelAndView.addObject("product", result);
		modelAndView.addObject("discount", discount);
		modelAndView.addObject("subsCheck", subsCheck);
		modelAndView.addObject("reviewList", reviewList);
		modelAndView.addObject("inquiryList", inquiryList);
		modelAndView.addObject("user_id", getUser.getUser_id());
		
		if (!checkChannel.isEmpty()) {
			modelAndView.setViewName("/product/productViewBiz");
		} else {
			modelAndView.addObject("checkSubs", checkSubs);
			modelAndView.setViewName("/product/productView");
		}
		
		return modelAndView;
	}
	
	@GetMapping("/{product_id}/editform")
	public ModelAndView updateProduct(@PathVariable(name = "product_id") String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		product.setProduct_id(product_id);
		Product result = productServiceImpl.viewProduct(product);
		modelAndView.setViewName("/product/productEditBiz");
		modelAndView.addObject("product", result);
		return modelAndView;
	}
	
	@GetMapping("/registform")
	public ModelAndView regitProduct() {
		ModelAndView modelAndView = new ModelAndView();
		String channel_id = (String)httpSession.getAttribute("channel_id");
		System.out.println();
		String product_id = "P" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.addObject("channel_id", channel_id);
		modelAndView.addObject("product_id", product_id);
		modelAndView.setViewName("/product/productRegistBiz");
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
