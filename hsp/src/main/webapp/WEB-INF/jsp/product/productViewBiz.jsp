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
                            <a href="/main">Home</a>
                        </li>
                        <li>
                            <a href="/product">Products</a>
                        </li>
                        <li>
                            <a href="/channel/${product.channel_id}">${product.channel_id}</a>
                        </li>
                        <li class="active">${product.product_name} </li>
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="product-details-area padding-30-row-col pt-75 pb-75">
            <div class="custom-container">
                <div class="row flex-row-reverse">
                    <div class="col-lg-9 col-md-12 col-12">
                        <div class="product-details-wrap">
                            <div class="product-details-wrap-top">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="product-details-slider-wrap">
                                            <div class="pro-dec-big-img-slider slick-initialized slick-slider">
                                                <div class="slick-list"><div class="slick-track" style="opacity: 1; width: 5654px; transform: translate3d(-514px, 0px, 0px);"><div class="single-big-img-style slick-slide slick-cloned" data-slick-index="-1" id="" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-2.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-2.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red"> - ${product.product_price}% !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide slick-current slick-active" data-slick-index="0" aria-hidden="false" tabindex="0" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-1.jpg" tabindex="0">
                                                            <img src="/product/display?filename=${product.product_img}" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red"> - ${product.discount}% 할인</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide" data-slick-index="1" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-2.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-2.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red"> - ${product.product_price}% !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide" data-slick-index="2" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-3.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-3.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide" data-slick-index="3" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-4.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-4.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide" data-slick-index="4" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-2.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-2.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide slick-cloned" data-slick-index="5" id="" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-1.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-1.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide slick-cloned" data-slick-index="6" id="" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-2.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-2.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide slick-cloned" data-slick-index="7" id="" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-3.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-3.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide slick-cloned" data-slick-index="8" id="" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-4.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-4.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div><div class="single-big-img-style slick-slide slick-cloned" data-slick-index="9" id="" aria-hidden="true" tabindex="-1" style="width: 514px;">
                                                    <div class="pro-details-big-img">
                                                        <a class="img-popup" href="assets/images/product-details/pro-details-b-large-2.jpg" tabindex="-1">
                                                            <img src="assets/images/product-details/pro-details-large-2.jpg" alt="">
                                                        </a>
                                                    </div>
                                                    <div class="pro-details-badges product-badges-position">
                                                        <span class="red">Sale !</span>
                                                    </div>
                                                </div></div></div>
                                                
                                                
                                                
                                                
                                            </div>
                                            <div class="product-dec-slider-small product-dec-small-style1 slick-initialized slick-slider">
                                                <div class="slick-list draggable"><div class="slick-track" style="opacity: 1; width: 1806px; transform: translate3d(-516px, 0px, 0px);"><div class="product-dec-small slick-slide slick-cloned" data-slick-index="-4" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-2.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="-3" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-3.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="-2" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-4.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="-1" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-2.jpg" alt="">
                                                </div><div class="product-dec-small active slick-slide slick-current slick-active" data-slick-index="0" aria-hidden="false" tabindex="0" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-1.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-active" data-slick-index="1" aria-hidden="false" tabindex="0" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-2.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-active" data-slick-index="2" aria-hidden="false" tabindex="0" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-3.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-active" data-slick-index="3" aria-hidden="false" tabindex="0" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-4.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide" data-slick-index="4" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-2.jpg" alt="">
                                                </div><div class="product-dec-small active slick-slide slick-cloned" data-slick-index="5" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-1.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="6" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-2.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="7" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-3.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="8" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-4.jpg" alt="">
                                                </div><div class="product-dec-small slick-slide slick-cloned" data-slick-index="9" id="" aria-hidden="true" tabindex="-1" style="width: 119px;">
                                                    <img src="assets/images/product-details/pro-details-small-2.jpg" alt="">
                                                </div></div></div>
                                                
                                                
                                                
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="product-details-content pro-details-content-pl">
                                            <div class="pro-details-category">
                                                <ul>
                                                    <li><a href="shop-filter.html">${product.channel_id} </a> / </li>
                                                    <li><a href="shop-filter.html">${product.product_name} </a></li>
                                                </ul>
                                            </div>
                                            <h1> ${product.product_name}</h1>
                                            <div class="pro-details-brand-review">
                                                <div class="pro-details-brand">
                                                    <span> 채널 ID: <a href="/channel/${product.channel_id}"> ${product.channel_id} </a></span>
                                                </div>
                                                <div class="pro-details-rating-wrap">
                                                    <span>5.00</span>
                                                    <div class="pro-details-rating">
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                    </div>
                                                    <a href="#"> 
                                                    	<c:if test="${product.orderable_cycle == 'S'}">일반상품</c:if>
					  									<c:if test="${product.orderable_cycle == 'W'}">정기상품</c:if> 
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="pro-details-price-short-description">
                                                <div class="pro-details-price">
                                                    <span class="new-price"><fmt:formatNumber value="${discount}" pattern="#,###" /> 원</span>
                                                    
                                                    <span class="old-price"><fmt:formatNumber value="${product.product_price}" pattern="#,###" /> 원</span> -정상가
                                                </div>
                                                <div class="pro-details-short-description">
                                                    <p>구독시 -${product.discount}%의 할인율 제공!</p>
                                                </div>
                                            </div>
                                            
                                          
                                            
                                            <div class="pro-details-action-wrap">
                                                <div class="pro-details-add-to-cart">
                                                    <form name="regit" action="/product/${product.product_id}/editform" method="get">
														<button type="submit">상품 수정</button>
													</form>
                                                </div>
                                                
                                            </div>
                                            <div class="product-details-meta">
                                                <ul>
                                                    <li><span>상품 ID:</span> ${product.product_id} </li>
                                                </ul>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-details-wrap-bottom">
                                <div class="product-details-description">
                                    <div class="entry-product-section-heading">
                                        <h2>상세 설명</h2>
                                    </div>
                                    ${product.product_detail}
                                    <p>
                                    </p>
                                </div>
                                
                                <div class="pro-details-review-wrap">
                                    <div class="entry-product-section-heading">
                                        <h2> 사용자 리뷰(2)</h2>
                                    </div>
                                    <div class="pro-details-review">
                                        <p><span>5.00</span> average based on 2 ratings.</p>
                                        
                                        <c:forEach items="${reviewList}" var = "reviewlist">
                                        
                                        <div class="single-pro-details-review">
                                            <div class="review-img">
                                                <img src="assets/images/client/client-1.jpeg" alt="">
                                            </div>
                                            <div class="review-content">
                                                <div class="review-name-rating">
                                                    <div class="review-rating">
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        ${reviewlist.product_grade}
                                                    </div>
                                                    <div class="review-name">
                                                        <h6>${reviewlist.review_title}</h6>
                                                    </div>
                                                </div>
                                                <p>${reviewlist.review_content}</p>
                                                <div class="review-date-btn">
                                                    <div class="review-date">
                                                        <span>  </span>
                                                    </div>
                                                    <div class="review-btn">
                                                        <a href="#"></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                       </c:forEach>
                                        

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-12 col-12">
                        <div class="sidebar-wrapper sidebar-wrapper-mr1">
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-2 mb-20">
                                <h4 class="sidebar-widget-title">상품 문의</h4>
                                <div class="product-highlight">
                                    <ul>
                                    	<c:forEach items="${inquiryList}" var = "quiryList">
                                    		<li>
                                            	<a href="/channel/${quiryList.inquiry_title}"> ${quiryList.inquiry_title} </a> <span> ${quiryList.inquiry_type} </span>
                                            	
                                        	</li>
                                    	</c:forEach>
                                        
                                    </ul>
                                </div>
                            </div>
                           
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
	
<%@ include file="../include/bizfooter.jsp"%>
</body>
</html>