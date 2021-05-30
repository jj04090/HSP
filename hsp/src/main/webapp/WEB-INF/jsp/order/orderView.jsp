<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order View</title>

<style>
.small1 { width: 500px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>주문 상세 확인</h1>
	
	
	<c:forEach items="${orderInfo}" var = "list">
		<ul>
			<li>주문 ID : ${list.order_id} </li>
			<li>상품 종류 : <c:if test="${list.order_type == 'S'}">일반상품</c:if>
					  <c:if test="${list.order_type == 'W'}">정기상품</c:if> 
			</li>
			<li>상품 명 : ${list.product_name} </li>
			<li>상품 ID : ${list.product_id} </li>
			<li>상품 개수 : ${list.product_qty} </li>
			<li>상품 가격 : ${list.price} </li>
			<li>상품 할인율 : ${list.discount} % </li> 
			<li>배송비 : ${list.delevery_fee} </li>
			<li>주소 : ${list.address} </li>
			<li>상세 주소 : ${list.detail_address} </li>
			<li>우편 번호 : ${list.zip_code} </li>
			<li>제품 상태: ${list.delevery_status} </li>
		</ul>
	</c:forEach>
	
</body>
</html>