<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/bizheader.jsp"%>
	
	<div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
        <div class="custom-container">
            <div class="breadcrumb-content text-center">
                <ul>
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li class="active">Inquiry</li>
                </ul>
            </div>
        </div>
    </div>
	

	
	<div class="col-lg-8">
                        <div class="blog-details-wrapper">
                            <div class="blog-details-top-content">
                                
                                <h1>${inquiry.inquiry_title}</h1>
                                <div class="blog-meta-3">
                                    <ul>
                                        <li><a href="#"> ${inquiry.user_id}</a> </li>
                                        <li><i class="far fa-calendar"></i> ${inquiry.inquiry_regit_date}</li>
                                        
                                        <li> </li>
                                    </ul>
                                </div>
                            </div>
                            
                            
                            
                            <div class="blog-details-middle-img">
                                
                            </div>
                            <p class="blog-details-paragraph-mb">${inquiry.inquiry_content}</p>
                            
                            
                            
                            
                            <div class="blog-author-wrap">
                                
                                <div class="blog-author-content">
                                    <h4>답변</h4>
                                    <p>${inquiry.answer}</p>
                                </div>
                            </div>
                            <div class="blog-prev-next-wrap">
                                <div class="row">
                                	<form name="answer" action="/inquiry/${inquiry.inquiry_id}/answereditform" method="get">
										<button type="submit">답변하기</button>
									</form>
									<form name="list" action="/inquiry/${inquiry.product_id}" method="get">
										<button type="submit">목록으로</button>
									</form>
                                </div>
                            </div>
                        </div>
                    </div>
	
<%@ include file="../include/bizfooter.jsp"%>
</body>
</html>