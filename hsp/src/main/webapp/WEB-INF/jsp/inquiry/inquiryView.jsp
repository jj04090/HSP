<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquiry View</title>

<style>
.small1 { width: 500px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>문의 상세 확인</h1>
	
	<ul>
		<li>문의 ID : ${inquiry.inquiry_id} </li>
		<li>유저 ID : ${inquiry.user_id} </li>
		<li>상품 ID : ${inquiry.product_id} </li>
		<li>문의 제목 : ${inquiry.inquiry_title} </li>
		<li>문의 내용 : ${inquiry.inquiry_content} </li>
	</ul>
	
</body>
</html>