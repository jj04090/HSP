<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/bizheader.jsp"%>
	
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
	
	<div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-1 mb-20">
		<h4 class="sidebar-widget-title">${product_id} 상품 문의 목록 </h4>
		<div class="sidebar-categories-list">
			<c:forEach items="${listInquiry}" var = "list">
				<ul>
					<li>제목 : <a href="/inquiry/${list.product_id}/${list.inquiry_id}"> <c:out value="${list.inquiry_title}" /> </a> </li>
					<li>내용 : <c:out value="${list.inquiry_content}" /></li>
				</ul>
			</c:forEach>
    	</div>
    </div>
	
<%@ include file="../include/bizfooter.jsp"%>
</body>
</html>