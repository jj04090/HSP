<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order View</title>

<style>
.small1 { width: 100px; }
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
			<li>상품 사진 : <img class='small1' src="/product/display?filename=${list.product_img}"> </li>
			<li>상품 ID : ${list.product_id} </li>
			<li>상품 개수 : ${list.product_qty} </li>
			<li>상품 가격 : ${list.price} </li>
			<li>상품 할인율 : ${list.discount} % </li> 
			<li>주소 : ${list.address} </li>
			<li>상세 주소 : ${list.detail_address} </li>
			<li>우편 번호 : ${list.zip_code} </li>
			
			<li>주문 상태 :
				<c:if test="${list.delevery_status == 'O'}">주문완료</c:if>
				<c:if test="${list.delevery_status == 'D'}">배송중</c:if> 
				<c:if test="${list.delevery_status == 'C'}">배송완료</c:if>
				<c:if test="${list.delevery_status == 'R'}">반품중</c:if> 
				<c:if test="${list.delevery_status == 'F'}">반품완료</c:if>
				<c:if test="${list.delevery_status == 'N'}">반품거부</c:if> 
			</li>
			
			<c:if test="${list.delevery_status == 'C'}">
				<div>
					<form name="return" action="/order/returnform" method="get">
						<input type="hidden" name="order_id" value="${list.order_id}">
						<input type="hidden" name="product_id" value="${list.product_id}">
						<button type="submit">반품 신청</button>
					</form>
				</div>
			</c:if>
				
			<c:if test="${list.delevery_status == 'O'}">
				<div>
					<form name="change" action="/order/change" method="post">
						<input type="hidden" name="_method" value="PUT" />
					
						<input type="hidden" name="order_id" value="${list.order_id}">
						<input type="hidden" name="product_id" value="${list.product_id}">
					
						<button type="submit" name="delevery_status" value="C">배송완료</button>
					</form>
				</div>
			</c:if>
			
		</ul>
	</c:forEach>
	
</body>
</html>