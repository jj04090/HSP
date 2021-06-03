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
	
	<ul>
		<li>게시글 ID : ${community.community_id} </li>
		<li>채널 ID : ${community.channel_id} </li>
		<li>미디어 파일 : <img class='small1' src="/hsp/community/display?filename=${community.mediafile}"> </li>
		<li>게시글 제목 : ${community.community_title} </li>
		<li>게시글 내용 : ${community.community_content} </li>
		<li>게시글 등록 날짜 : ${community.regit_date} </li>
		
		<c:forEach items="${listComment}" var = "list">
			<ul>
				<li>댓글 내용 : <c:out value="${list.comment_content}" /></li>
				<li>댓글 작성자 : <c:out value="${list.user_id}" /></li>
			</ul>
		</c:forEach>
	</ul>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>