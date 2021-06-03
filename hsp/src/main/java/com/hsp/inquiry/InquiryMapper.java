package com.hsp.inquiry;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InquiryMapper {
	public List<Inquiry> list(Inquiry inquiry) throws Exception;

	public Inquiry select(Inquiry inquiry) throws Exception;

	public void insert(Inquiry inquiry) throws Exception;

	public void update(Inquiry inquiry) throws Exception;
	
	public void answer(Inquiry inquiry) throws Exception;

	public void delete(Inquiry inquiry) throws Exception;
}