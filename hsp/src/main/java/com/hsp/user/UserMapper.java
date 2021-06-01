package com.hsp.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	public User select(User user) throws Exception;
	public User insert(User user) throws Exception;
	public User update(User user) throws Exception;
	public User delete(User user) throws Exception;
	
}