package com.hsp.community;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {
	public List<Community> list() throws Exception;

	public Community select(Community community) throws Exception;

	public void insert(Community community) throws Exception;

	public void update(Community community) throws Exception;

	public void delete(Community community) throws Exception;
}