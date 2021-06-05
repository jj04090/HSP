<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
	
	<div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
            <div class="custom-container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li class="active">모든 채널 보기</li>
                    </ul>
                </div>
            </div>
        </div>
	
	
	<div class="blog-area pt-75 pb-75">
            <div class="container">
                <div class="row grid" style="position: relative; height: 1348.49px;">
                
                <c:forEach items="${channelList}" var = "list" varStatus="status">
                    <div class="col-lg-4 col-md-6 col-12 col-sm-6 grid-item wow tmFadeInUp" style="visibility: visible; animation-name: medizinAnimationFadeInUp; position: absolute; left: 0%; top: 0px;">
                        <div class="blog-wrap-2 mb-30">
                            <div class="blog-img-2">
                                <a href="/channel/${list.channel_id}"><img src="/channel/display?filename=${list.channel_img}" alt=""></a>
                                <div class="blog-tag-2">
                                    <a href="blog-details.html">HOT</a>
                                </div>
                            </div>
                            <div class="blog-content-2">
                                <div class="blog-meta-2">
                                    <ul>
                                        <li><i class="far fa-eye"></i> ${subs[status.index]} 구독</li>
                                        <li><i class="far fa-calendar"></i> 
                                        	<c:if test="${list.category == 'A'}"> 모든 식품 </c:if>
                                        	<c:if test="${list.category == 'K'}"> 한식 </c:if>
                                        	<c:if test="${list.category == 'C'}"> 중식 </c:if>
                                        	<c:if test="${list.category == 'S'}"> 양식 </c:if>
                                        </li>
                                    </ul>
                                </div>
                                <h3><a href="/channel/${list.channel_id}"> <c:out value="${list.channel_name}" /> </a></h3>
                                <div class="blog-btn">
                                    <a href="blog-details.html">Read more <i class="far fa-long-arrow-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </c:forEach>
                    
                </div>
                
            </div>
        </div>
	
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>