<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product View</title>

<style>
.small1 { width: 500px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>상품 상세 확인</h1>
	
	<ul>
		<li>상품 ID : ${product.product_id} </li>
		<li>채널 ID : ${product.channel_id} </li>
		<li>상품 사진 : <img class='small1' src="/hsp/product/display?filename=${product.product_img}"> </li>
		<li>상품 이름 : ${product.product_name} </li>
		<li>상품 가격 : ${product.product_price} </li>
		<li>상품 할인율 : ${product.discount} </li>
		<li>상품 상세 정보 : ${product.product_detail} </li>
		<li>상품 종류 : <c:if test="${product.orderable_cycle == 'S'}">일반상품</c:if>
					  <c:if test="${product.orderable_cycle == 'W'}">정기상품</c:if> 
		</li>
	</ul>
	
</body>
</html>