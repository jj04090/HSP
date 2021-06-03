<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review List</title>

<style>
.small1 { width: 100px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>리뷰 리스트</h1>
	
	<c:forEach items="${listReview}" var = "list">
		<ul>
			<li>사진 : <img class='small1' src="/hsp/review/display?filename=${list.review_img}"> </li>
			<li>제목 : <a href="/hsp/review/${list.review_id}"> <c:out value="${list.review_title}" /> </a> </li>
			<li>내용 : <c:out value="${list.review_content}" /></li>
			<li>평점 : <c:out value="${list.review_grade}" /></li>
		</ul>
	</c:forEach>
	
</body>
</html>