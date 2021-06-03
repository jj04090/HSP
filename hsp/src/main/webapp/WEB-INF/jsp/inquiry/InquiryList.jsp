<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquiry List</title>

<style>
.small1 { width: 100px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>게시글 리스트</h1>
	
	<c:forEach items="${listInquiry}" var = "list">
		<ul>
			<li>제목 : <a href="/hsp/community/${list.inquiry_id}"> <c:out value="${list.inquiry_title}" /> </a> </li>
			<li>내용 : <c:out value="${list.inquiry_content}" /></li>
			<li>등록날짜 : <c:out value="${list.inquiry_regit_date}" /></li>
		</ul>
	</c:forEach>
	
</body>
</html>