package com.hsp.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.channel.Channel;
import com.hsp.channel.ChannelMapper;
import com.hsp.channel.Subscribe;
import com.hsp.channel.SubscribeMapper;
import com.hsp.orders.OrderDetail;
import com.hsp.orders.OrderDetailMapper;
import com.hsp.product.Product;
import com.hsp.product.ProductMapper;
import com.hsp.review.Review;
import com.hsp.review.ReviewMapper;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	ReviewMapper reviewMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	SubscribeMapper subscribeMapper;
	@Autowired
	OrderDetailMapper orderDetailMapper;
	@Autowired
	ChannelMapper channelMapper;

	@Override
	public Product getMaxReview() {
		Review review = new Review();
		Product product = new Product();
		try {
			review = reviewMapper.highRate();
			product.setProduct_id(review.getProduct_id());
			product = productMapper.select(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public Product mostOrdered() {
		Product product = new Product();
		try {
			OrderDetail orderDetail = orderDetailMapper.mostSelling();
			product.setProduct_id(orderDetail.getProduct_id());
			
			product = productMapper.select(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public List<Product> sellingList() {
		List<Product> productList = null;
		
		try {
			productList = productMapper.sellingList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<Channel> channelList() {
		List<Channel> channel = null;
		
		try {
			channel = channelMapper.topChannel();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return channel;
	}

	@Override
	public List<String> subsCount(List<Channel> channel) {
		List<String> count = new ArrayList<String>();
		
		try {
			for (Channel channels : channel) {
				Subscribe subscribe = new Subscribe();
				subscribe.setChannel_id(channels.getChannel_id());
				String subscount = subscribeMapper.count(subscribe);
				
				count.add(subscount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}

	@Override
	public String totalSubs(String channel_id) {
		String count = "";
		Subscribe subs = new Subscribe();
		subs.setChannel_id(channel_id);
		
		try {
			count = subscribeMapper.count(subs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	

}