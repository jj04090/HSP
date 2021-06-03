<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review View</title>

<style>
.small1 { width: 500px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>리뷰 상세 확인</h1>
	
	<ul>
		<li>리뷰 ID : ${reivew.reivew_id} </li>
		<li>주문 ID : ${reivew.order_id} </li>
		<li>상품 ID : ${reivew.product_id} </li>
		<li>미디어 파일 : <img class='small1' src="/hsp/reivew/display?filename=${reivew.reivew_img}"> </li>
		<li>리뷰 제목 : ${reivew.reivew_title} </li>
		<li>리뷰 내용 : ${reivew.reivew_content} </li>
		<li>평점 : ${reivew.reivew_grade} </li>
	</ul>
	
</body>
</html>