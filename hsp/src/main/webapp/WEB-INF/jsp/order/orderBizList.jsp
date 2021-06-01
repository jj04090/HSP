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
	<h1>사업자 주문 리스트</h1>
	
	<c:forEach items="${ordersList}" var = "list">
		<ul>
			<li>주문 ID : <a href="/order/${list.order_id}"> <c:out value="${list.order_id}" /> </a> </li>
			<li>상품 ID : <c:out value="${list.product_id}" /> </li>
			<li>상품 수량 : <c:out value="${list.product_qty}" /> </li>
			<li>상품 가격 : <c:out value="${list.price}" /> </li>
			<li>주문 상태 :
				<c:if test="${list.delevery_status == 'O'}">주문완료</c:if>
				<c:if test="${list.delevery_status == 'D'}">배송중</c:if> 
				<c:if test="${list.delevery_status == 'C'}">배송완료</c:if>
				<c:if test="${list.delevery_status == 'R'}">반품중</c:if> 
				<c:if test="${list.delevery_status == 'F'}">반품완료</c:if>
				<c:if test="${list.delevery_status == 'N'}">반품거부</c:if> 
			</li>
			
			<div>
				<button type="submit" formmethod="get" onclick="location.href='<%=request.getContextPath()%>/order/cancel/${list.order_id}'">주문 취소</button>
				
			</div>
		</ul>
	</c:forEach>
	
</body>
</html>
