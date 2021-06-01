<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return View</title>

<style>
.small1 { width: 100px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>반품 확인</h1>
	
	<ul>
		<li>리턴 ID : ${returns.return_id} </li>
		<li>주문 ID : ${returns.order_id} </li>
		<li>제품 이름 : ${returns.product_id} </li>
		<li>상세 사유 : ${returns.return_reason} </li>
	
	
		<div>
			<form name="change" action="/order/change" method="post">
				<input type="hidden" name="_method" value="PUT" />
					
				<input type="hidden" name="order_id" value="${returns.order_id}">
				<input type="hidden" name="product_id" value="${returns.product_id}">
					
				<button type="submit" name="delevery_status" value="F">반품 완료</button>
				<button type="submit" name="delevery_status" value="N">반품 거부</button>
			</form>
		</div>
	</ul>
</body>
</html>