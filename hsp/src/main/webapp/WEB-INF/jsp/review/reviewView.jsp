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
		<li>리뷰 ID : ${reivew.reivew_id} </li>
		<li>주문 ID : ${reivew.order_id} </li>
		<li>상품 ID : ${reivew.product_id} </li>
		<li>미디어 파일 : <img class='small1' src="/hsp/reivew/display?filename=${reivew.reivew_img}"> </li>
		<li>리뷰 제목 : ${reivew.reivew_title} </li>
		<li>리뷰 내용 : ${reivew.reivew_content} </li>
		<li>평점 : ${reivew.reivew_grade} </li>
	</ul>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>