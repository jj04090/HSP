<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return List</title>

<style>
.small1 { width: 100px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>반품 리스트</h1>
	
	<c:forEach items="${returnsList}" var="list">
		<ul>
			<li>반품 Id : <a href="/order/return/${list.return_id}"> <c:out value="${list.return_id}" /> </a> </li>
			<li>주문 Id : ${list.order_id}</li>
			<li>상품 Id : ${list.product_id}</li>
		</ul>
	</c:forEach>
	
</body>
</html>