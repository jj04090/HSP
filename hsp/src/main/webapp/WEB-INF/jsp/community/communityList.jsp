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
                    <li class="active">Community</li>
                </ul>
            </div>
        </div>
    </div>
	
	<c:forEach items="${listCommunity}" var = "list">
		<ul>
			<li>사진 : <img class='small1' src="/hsp/community/display?filename=${list.mediafile}"> </li>
			<li>제목 : <a href="/hsp/community/${list.community_id}"> <c:out value="${list.community_title}" /> </a> </li>
			<li>내용 : <c:out value="${list.community_content}" /></li>
			<li>등록날짜 : <c:out value="${list.regit_date}" /></li>
		</ul>
	</c:forEach>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>