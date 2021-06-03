package com.hsp.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	InquiryMapper inquiryMapper;
	
	@Override
	public List<Inquiry> viewInquiryList() {
		List<Inquiry> listinquiry = null;
		try {
			listinquiry = inquiryMapper.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listinquiry;
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
			inquiryMapper.update(inquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInquiry(Inquiry inquiry) {
		// TODO Auto-generated method stub

	}
}