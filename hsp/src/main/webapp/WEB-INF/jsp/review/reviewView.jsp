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
                    <li class="active">Review</li>
                </ul>
            </div>
        </div>
    </div>
	
	<ul>
		<li>리뷰 ID : ${review.review_id} </li>
		<li>주문 ID : ${review.order_id} </li>
		<li>상품 ID : ${review.product_id} </li>
		<li>미디어 파일 : <img class='small1' src="/review/display?filename=${review.review_img}"> </li>
		<li>리뷰 제목 : ${review.review_title} </li>
		<li>리뷰 내용 : ${review.review_content} </li>
		<li>평점 : ${review.product_grade} </li>
	</ul>
	<form name="edit" action="/${review.review_id}/editform" method="get">
		<button type="submit">리뷰 수정</button>
	</form>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>