package com.hsp.inquiry;

import java.util.List;

public interface InquiryService {
	public void registInquiry(Inquiry inquiry);
	public void updateInquiry(Inquiry inquiry);
	public void deleteInquiry(Inquiry inquiry);
	public List<Inquiry> viewInquiryList(String product_id);
	public Inquiry viewInquiry(Inquiry inquiry);
	public void updateAnswer(Inquiry inquiry);
}