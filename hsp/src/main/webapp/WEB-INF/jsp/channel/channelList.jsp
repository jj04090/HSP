<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

	<c:forEach items="${channelList}" var = "list" varStatus="status">
		<c:out value="${list.channel_id}" />
		<c:out value="${list.channel_name}" />
		<img src="/channel/display?filename=${list.channel_img}" alt="">
		<c:out value="${list.category}" />
		<c:out value="${list.introduction}" />
	</c:forEach>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>