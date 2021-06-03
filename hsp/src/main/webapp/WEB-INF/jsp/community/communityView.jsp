<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community View</title>

<style>
.small1 { width: 500px; }
.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>게시글 상세 확인</h1>
	
	<ul>
		<li>게시글 ID : ${community.community_id} </li>
		<li>채널 ID : ${community.channel_id} </li>
		<li>미디어 파일 : <img class='small1' src="/hsp/community/display?filename=${community.mediafile}"> </li>
		<li>게시글 제목 : ${community.community_title} </li>
		<li>게시글 내용 : ${community.community_content} </li>
		<li>게시글 등록 날짜 : ${community.regit_date} </li>
		<li>댓글 내용 : ${comment.comment_content} </li>
		<li>댓글 게시글 ID : ${comment.community_id} </li>
	</ul>
	
</body>
</html>