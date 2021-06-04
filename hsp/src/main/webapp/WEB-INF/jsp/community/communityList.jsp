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
	
	<div class="blog-area pt-75 pb-75">
            <div class="container">
                <div class="row grid" style="position: relative; height: 1222.6px;">
                    <c:forEach items="${listCommunity}" var = "list">
	                    <div class="col-lg-4 col-md-6 col-12 col-sm-6 grid-item wow tmFadeInUp" style="visibility: visible; animation-name: medizinAnimationFadeInUp; position: absolute; left: 33.3333%; top: 0px;">
	                        <div class="blog-wrap-2 mb-30">
	                            <div class="blog-img-2">
	                                <a href="blog-details.html"><img class='small1' src="/community/display?filename=${list.mediafile}" alt=""></a>
	                            </div>
	                            <div class="blog-content-2">
	                                <div class="blog-meta-2">
	                                    <ul>
	                                        <li><i class="far fa-calendar"></i> <c:out value="${list.regit_date}" /></li>
	                                    </ul>
	                                </div>
	                                <h3><c:out value="${list.community_title}" /></h3>
	                                <div class="blog-btn">
	                                    <a href="/community/${list.channel_id}/${list.community_id}">자세히 보기<i class="far fa-long-arrow-right"></i></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
					</c:forEach>
                </div>
                <div class="pro-pagination-style text-center">
                    <ul>
                        <li><a class="active" href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a class="next" href="#"><i class="far fa-angle-double-right"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        
    <form name="regit" action="/community/registform" method="get">
		<button type="submit">게시글 등록</button>
	</form>
<%@ include file="../include/footer.jsp"%>
</body>
</html>