package com.hsp.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	public User select(User user) throws Exception;
}