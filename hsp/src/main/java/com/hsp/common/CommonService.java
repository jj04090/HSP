package com.hsp.common;

import java.util.List;

import com.hsp.channel.Channel;
import com.hsp.product.Product;

public interface CommonService {
	public Product getMaxReview();
	public Product mostOrdered();
	public List<String> subsCount(List<Channel> channel);
	public List<Product> sellingList();
	public List<Channel> channelList();
}
