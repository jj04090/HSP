<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

	<!-- <h1>${channel_id}의 상품 리스트</h1>  -->
	
	<div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
            <div class="custom-container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="/main">Home</a>
                        </li>
                        <li class="/channel">channel</li>
                    </ul>
                </div>
            </div>
        </div>
	
	<div class="shop-area pt-75 pb-55">
		<div class="custom-container">
			<div class="row flex-row-reverse">
				<div class="col-lg-9">
					<div class="shop-topbar-wrapper">
						<div class="totall-product">
							<p> " ${channel.channel_name}의 상품 리스트 " </p>
						</div>
					</div>
					
					<div class="shop-bottom-area">
						<div class="row">
							
							<c:forEach items="${listProduct}" var = "list" varStatus="status">
							<!-- 상품 하나 하나 -->
							<div class="col-xl-3 col-lg-4 col-md-4 col-12 col-sm-6 wow tmFadeInUp" style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
                                    <div class="single-product-wrap mb-50">
                                        <div class="product-img-action-wrap mb-10">
                                            <div class="product-img product-img-zoom">
                                                <a href="/product/${list.channel_id}/${list.product_id}">
                                                    <img class="default-img" src="/product/display?filename=${list.product_img}" alt="" >
                                                    <img class="hover-img" src="/product/display?filename=${list.product_img}" alt="">
                                                </a>
                                            </div>
                                            <div class="product-action-1">
                                                <button aria-label="쇼핑카트 추가"><i class="far fa-shopping-bag"></i></button>
                                                <button aria-label="좋아요"><i class="far fa-heart"></i></button>
                                            </div>
                                            <div class="product-badges product-badges-position product-badges-mrg">
                                                <span class="red"> -<c:out value="${list.discount}" />% </span>
                                            </div>
                                        </div>
                                        <div class="product-content-wrap">
                                            <div class="product-category">
                                                <a href="shop.html">
                                               		<c:if test="${list.orderable_cycle == 'S'}"> 일반상품 </c:if>
					  								<c:if test="${list.orderable_cycle == 'W'}"> 정기상품 </c:if> 
                                                </a>
                                            </div>
                                            <h2><a href="/product/${list.channel_id}/${list.product_id}"> <c:out value="${list.product_name}" /> </a></h2>
                                            <div class="product-price">
                                                <span class="new-price"> <fmt:formatNumber value="${discountPrice[status.index]}" pattern="#,###" /> 원 </span>
                                                <span class="old-price"> <fmt:formatNumber value="${list.product_price}" pattern="#,###" /> 원 </span>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <!-- 상품 하나 하나 끝 -->
                            </c:forEach>
							
							<!-- 사업자 화면에 표시 -->
							<!-- 
							<form name="regit" action="/product/registform" method="get">
								<button type="submit">상품 등록</button>
							</form>
							 -->
	
					</div>
				</div>
					
				</div>
				
				<div class="col-lg-3">
                        <div class="sidebar-wrapper sidebar-wrapper-mr1">
                        	
                        	<div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-1 mb-20">
                                <h4 class="sidebar-widget-title">채널 대표사진</h4>
                                <div class="sidebar-brand-list">
                                    <img class="default-img" src="/product/display?filename=${channel.channel_img}" alt="" height="180" width="180">
                                    
                                </div>
                            </div>
                            
                            <div class="product-details-content pro-details-content-pl">
                                	<div class="pro-details-action-wrap">
                                                <div class="pro-details-add-to-cart">
                                                	<c:if test="${checkSubs == 'O'}">
	                                    				<form name="subscribe" action="/channel/subscribe/${list.channel_id}" method="get">
															<button type="submit">구독중</button>
														</form>
                                					</c:if>
                                	
                                					<c:if test="${checkSubs == 'X'}">
                                						<form name="subscribe" action="/channel/subscribe/${list.channel_id}" method="get">
															<button type="submit" style="background-color: red;">구독하기</button>
														</form>
                                					</c:if>
                                					
                                                	
                                                    
                                                </div>
                              		</div>
                               </div>
                        	
                        	<br>
                        
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-1 mb-20">
                                <h4 class="sidebar-widget-title">채널 설명</h4>
                                <div class="sidebar-categories-list">
                                    <ul>
                                        <li ><a href="shop.html">채널 이름</a>
                                            <ul>
                                                <Li><a href="shop.html">${channel.channel_name}</a></li>
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
                                        <li><a href="shop.html">사업자 번호 </a>
                                        	<ul>
                                                <li><a href="shop.html">${channel.business_no}</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-1 mb-20">
                                <h4 class="sidebar-widget-title">채널 커뮤니티</h4>
                                <div class="sidebar-brand-list">
                                    <ul>
                                    	<c:forEach items="${communityList}" var = "commList" varStatus="status">
                                    		<li><a href="/community/${channel.channel_id}/${commList.community_id}">${commList.community_title} <span>(6)</span></a></li>
                                    	</c:forEach>
                                    </ul>
                                </div>
                            </div>
                            
                            
                        </div>
                    </div>
				
			</div>
		</div>
	</div>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>