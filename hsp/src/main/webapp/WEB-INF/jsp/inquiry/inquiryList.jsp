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
                    <li class="active">Inquiry</li>
                </ul>
            </div>
        </div>
    </div>
	
	<c:forEach items="${listInquiry}" var = "list">
		<ul>
			<li>제목 : <a href="/hsp/inquiry/${list.inquiry_id}"> <c:out value="${list.inquiry_title}" /> </a> </li>
			<li>내용 : <c:out value="${list.inquiry_content}" /></li>
		</ul>
	</c:forEach>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>