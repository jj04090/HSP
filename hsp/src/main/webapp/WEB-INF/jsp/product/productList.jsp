<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>

<style>
.small1 { width: 100px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>상품 리스트</h1>
	
	<c:forEach items="${listProduct}" var = "list">
		<ul>
			<li>사진 : <img class='small1' src="/hsp/product/display?filename=${list.product_img}"> </li>
			<li>이름 : <a href="/hsp/product/${list.product_id}"> <c:out value="${list.product_name}" /> </a> </li>
			<li>가격 : <c:out value="${list.product_price}" /></li>
			<li>할인율 : <c:out value="${list.discount}" /></li>
		</ul>
	</c:forEach>
	
</body>
</html>