package com.hsp.review;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	public List<Review> list(Review review) throws Exception;

	public Review select(Review review) throws Exception;

	public void insert(Review review) throws Exception;

	public void update(Review review) throws Exception;

	public void delete(Review review) throws Exception;
	
	public Review highRate() throws Exception;
}