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

	<form name="regit" action="/review/registform" method="get">
		<button type="submit">리뷰 등록</button>
	</form>
	
	<div class="pro-details-review-wrap">
                                    <div class="entry-product-section-heading">
                                        <h2> 상품 리뷰</h2>
                                    </div>
                                    <div class="pro-details-review">
                                    	<c:forEach items="${listReview}" var = "list">
	                                        <div class="single-pro-details-review">
	                                            <div class="review-img">
	                                                <img class='small1' src="/review/display?filename=${list.review_img}" alt="">
	                                            </div>
	                                            <div class="review-content">
	                                                <div class="review-name-rating">
	                                                    <div class="review-rating">
	                                                    	<script>
	                                                    		for (var i = 0; i < ${list.product_grade}; i++) {
		                                                    	    document.write('<i class="fas fa-star"></i>');
	                                                    		}
	                                                    	</script>
	                                                    </div>
	                                                    <div class="review-name">
	                                                        <h6><a href="/review/${list.product_id}/${list.review_id}"> <c:out value="${list.review_title}" /> </a></h6>
	                                                    </div>
	                                                </div>
	                                                <p>${list.review_content}</p>
	                                            </div>
	                                        </div>
										</c:forEach>
                                    </div>
                                </div>
                                	
<%@ include file="../include/footer.jsp"%>
</body>
</html>