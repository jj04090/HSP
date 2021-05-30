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
	<h1>주문 리스트</h1>
	
	<c:forEach items="${ordersList}" var = "list">
		<ul>
			<li> 주문 ID : <a href="/order/${list.order_id}"> <c:out value="${list.order_id}" /> </a> </li>
			<li>주문 종류 : 
				<c:if test="${list.order_type == 'S'}">일반상품</c:if>
				<c:if test="${list.order_type == 'W'}">정기상품</c:if>
			</li>
			<li>주문 일자 : <c:out value="${list.order_date}" /> </li>
			<li>결제 상태 : <c:out value="${list.order_status}" /> </li>
		</ul>
	</c:forEach>
	
</body>
</html>