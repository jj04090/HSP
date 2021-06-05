package com.hsp.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	InquiryMapper inquiryMapper;
	
	@Override
	public List<Inquiry> viewInquiryList(String product_id) {
		Inquiry inquiry = new Inquiry();
		inquiry.setProduct_id(product_id);
		List<Inquiry> listInquiry = null;
		try {
			listInquiry = inquiryMapper.list(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listInquiry;
	}
	
	@Override
	public List<Inquiry> viewInquiryMyList(String user_id) {
		Inquiry inquiry = new Inquiry();
		inquiry.setUser_id(user_id);
		List<Inquiry> listInquiry = null;
		try {
			listInquiry = inquiryMapper.myList(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listInquiry;
	}
	
	@Override
	public Inquiry viewInquiry(Inquiry inquiry) {
		Inquiry result = null;
		try {
			result = inquiryMapper.select(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void registInquiry(Inquiry inquiry) {
		try {
			inquiryMapper.insert(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateInquiry(Inquiry inquiry) {
		try {
			inquiryMapper.update(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateAnswer(Inquiry inquiry) {
		try {
			inquiryMapper.answer(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInquiry(Inquiry inquiry) {
		// TODO Auto-generated method stub

	}
}