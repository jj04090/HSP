package com.hsp.common;

import java.util.List;

import com.hsp.channel.Channel;
import com.hsp.product.Product;

public interface CommonService {
	public Product getMaxReview();
	public Product mostOrdered();
	public List<Product> sellingList();
	public List<Channel> channelList();
}
