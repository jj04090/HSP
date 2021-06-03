<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>

<style>
.small1 { width: 100px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>사업자 주문 상세보기</h1>
	
	<c:forEach items="${orderInfoList}" var = "orderInfo">
	
	<ul>
			<li>주문 ID : ${orderInfo.order_id} </li>
			<li>상품 종류 : <c:if test="${orderInfo.order_type == 'S'}">일반상품</c:if>
					  <c:if test="${orderInfo.order_type == 'W'}">정기상품</c:if> 
			</li>
			<li>상품 명 : ${orderInfo.product_name} </li>
			<li>상품 사진 : <img class='small1' src="/product/display?filename=${orderInfo.product_img}"> </li>
			<li>상품 ID : ${orderInfo.product_id} </li>
			<li>상품 개수 : ${orderInfo.product_qty} </li>
			<li>상품 가격 : ${orderInfo.price} </li>
			<li>상품 할인율 : ${orderInfo.discount} % </li> 
			<li>주소 : ${orderInfo.address} </li>
			<li>상세 주소 : ${orderInfo.detail_address} </li>
			<li>우편 번호 : ${orderInfo.zip_code} </li>
			
			<li>주문 상태 :
				<c:if test="${orderInfo.delevery_status == 'O'}">주문완료</c:if>
				<c:if test="${orderInfo.delevery_status == 'D'}">배송중</c:if> 
				<c:if test="${orderInfo.delevery_status == 'C'}">배송완료</c:if>
				<c:if test="${orderInfo.delevery_status == 'R'}">반품중</c:if> 
				<c:if test="${orderInfo.delevery_status == 'F'}">반품완료</c:if>
				<c:if test="${orderInfo.delevery_status == 'N'}">반품거부</c:if> 
			</li>
			
	</ul>
	
	<div>
			<form name="change" action="/order/change" method="post">
				<input type="hidden" name="_method" value="PUT" />
					
				<input type="hidden" name="order_id" value="${orderInfo.order_id}">
				<input type="hidden" name="product_id" value="${orderInfo.product_id}">
					
				<c:if test="${orderInfo.delevery_status == 'O'}">
					<button type="submit" name="delevery_status" value="D">배송 등록</button>
				</c:if>
					
				<c:if test="${orderInfo.delevery_status == 'R'}">
					<button type="submit" name="delevery_status" value="F">반품 완료</button>
					<button type="submit" name="delevery_status" value="N">반품 거부</button>
				</c:if>
			</form>
	</div>
	
	</c:forEach>
	
</body>
</html>
