<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
	
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
	
	<ul>
		<li>문의 ID : ${inquiry.inquiry_id} </li>
		<li>유저 ID : ${inquiry.user_id} </li>
		<li>상품 ID : ${inquiry.product_id} </li>
		<li>문의 제목 : ${inquiry.inquiry_title} </li>
		<li>문의 내용 : ${inquiry.inquiry_content} </li>
	</ul>
	<form name="edit" action="/${inquiry.inquiry_id}/editform" method="get">
		<button type="submit">게시글 수정</button>
	</form>
	<form name="answer" action="/${inquiry.inquiry_id}/editanswerform" method="get">
		<button type="submit">답글 달기</button>
	</form>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>