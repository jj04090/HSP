package com.hsp.inquiry;

import java.util.List;

public interface InquiryService {
	public void registInquiry(Inquiry inquiry);
	public void updateInquiry(Inquiry inquiry);
	public void deleteInquiry(Inquiry inquiry);
	public List<Inquiry> viewInquiryList(Inquiry inquiry);
	public Inquiry viewInquiry(Inquiry inquiry);
}
