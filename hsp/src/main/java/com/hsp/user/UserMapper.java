package com.hsp.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	public User select(User user) throws Exception;
	public void insert(User user) throws Exception;
	public void update(User user) throws Exception;
	public void delete(User user) throws Exception;
}