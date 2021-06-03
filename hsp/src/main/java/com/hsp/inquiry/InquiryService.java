package com.hsp.inquiry;

import java.util.List;

public interface InquiryService {
	public void registInquiry(Inquiry inquiry);
	public void updateInquiry(Inquiry inquiry);
	public void deleteInquiry(Inquiry inquiry);
	public List<Inquiry> viewInquiryList();
	public Inquiry viewInquiry(Inquiry inquiry);
	public void updateAnswer(Inquiry inquiry);
}