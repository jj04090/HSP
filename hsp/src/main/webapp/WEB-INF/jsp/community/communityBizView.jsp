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
                    <li class="active">Community</li>
                </ul>
            </div>
        </div>
    </div>
		<div class="blog-details-area padding-30-row-col pt-75 pb-75">
            <div class="container">
                <div class="row flex-row-reverse">
                    <div class="col-lg-8">
	<div class="blog-details-wrapper">
                            <div class="blog-details-top-content">
                                
                                <h1>${community.community_title}</h1>
                                <div class="blog-meta-3">
                                    <ul>
                                        <li><a href="#"> 등록자</a> </li>
                                        <li><i class="far fa-calendar"></i> ${community.regit_date}</li>
                                    </ul>
                                </div>
                            </div>
                            <img src="/community/display?filename=${community.mediafile}" alt="">
                            
                            <p>${community.community_content}</p>
                            <div class="blog-details-middle-img">
                                
                            </div>
                            
                            
                            
                            
                            
                            
                            
                            <div class="blog-reply-wrapper">
                                
                                
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="input-style blog-input-style">
                                                
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="input-style blog-input-style">
                                                
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="textarea-style blog-textarea-style">
                                                
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="blog-comment-submit">
<!-- 버튼 원래 있던 자리 -->
                                    </div>
                                </form>
                            </div>
		                    <c:forEach items="${listComment}" var = "list">
                            	<div class="blog-author-wrap">
		                        	<div class="blog-author-wrap">
		                                <div class="blog-author-content">
		                                    <h4>${list.user_id}</h4>
		                                    <p>${list.comment_content}</p>
		                                </div>
		                            </div>
                            	</div>
							</c:forEach>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="sidebar-wrapper sidebar-wrapper-mr1">
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-1 mb-20">
                                <h4 class="sidebar-widget-title">채널 설명 </h4>
                                <div class="sidebar-categories-list">
                                    <ul>
                                        <li><a href="shop.html">채널 이름</a>
                                            <ul>
                                                <li><a href="shop.html">${channel.channel_name}</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="shop.html">채널 카테고리</a>
                                        	<ul>
                                                <li><a href="shop.html">${channel.category}</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="shop.html">채널 인사말 </a>
                                        	<ul>
                                                <li><a href="shop.html">${channel.introduction}</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form name="edit" action="/community/${community.community_id}/editform" method="get">
			<button type="submit">게시글 수정</button>
		</form>
		<form name="regit" action="/community/commenregistform" method="get">
			<button type="submit">댓글 등록</button>
		</form>
		<form name="list" action="/community/${community.channel_id}" method="get">
			<button type="submit">목록으로</button>
		</form>


<%@ include file="../include/bizfooter.jsp"%>
</body>
</html>