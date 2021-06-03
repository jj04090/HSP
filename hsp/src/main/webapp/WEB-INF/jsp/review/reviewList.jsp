<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
	
	<div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
        <div class="custom-container">
            <div class="breadcrumb-content text-center">
                <ul>
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li class="active">Review</li>
                </ul>
            </div>
        </div>
    </div>
	
	<c:forEach items="${listReview}" var = "list">
		<ul>
			<li>사진 : <img class='small1' src="/review/display?filename=${list.review_img}"> </li>
			<li>제목 : <a href="/review/${list.review_id}"> <c:out value="${list.review_title}" /> </a> </li>
			<li>내용 : <c:out value="${list.review_content}" /></li>
			<li>평점 : <c:out value="${list.review_grade}" /></li>
		</ul>
	</c:forEach>
	
	<form name="regit" action="/review/registform" method="get">
		<button type="submit">리뷰 등록</button>
	</form>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>