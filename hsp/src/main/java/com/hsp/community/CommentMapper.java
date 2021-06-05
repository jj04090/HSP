package com.hsp.community;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	public List<Comment> list(Comment comment) throws Exception;

	public void insert(Comment comment) throws Exception;

	public void update(Comment comment) throws Exception;

	public void delete(Comment comment) throws Exception;
	
	public Comment select(Comment comment) throws Exception;
}