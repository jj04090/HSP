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
                            <a href="main">Home</a>
                        </li>
                        <li class="active">모든 상품</li>
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="shop-area adding-30-row-col pt-75 pb-75">
            <div class="custom-container">
                <div class="row flex-row-reverse">
                    <div class="col-lg-12">
                        <div class="shop-topbar-wrapper">
                            <div class="totall-product">
                                <p> "${channel_id}"의 모든 상품</p>
                            </div>
                            
                        </div>
                        <div class="product-filter-wrapper">
                            <div class="row">
                                <div class="col-width-16-2 custom-common-column">
                                    <div class="sidebar-widget sidebar-widget-height mb-20">
                                        <h4 class="sidebar-widget-title widget-title-font-dec">Sort by </h4>
                                        <div class="sidebar-sort-list">
                                            <ul>
                                                <li><a href="#">Popularity</a></li>
                                                <li><a href="#">Average rating</a></li>
                                                <li><a href="#">Latest</a></li>
                                                <li><a href="#">Price: low to high</a></li>
                                                <li><a href="#">Price: high to low</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-width-16-2 custom-common-column">
                                    <div class="sidebar-widget sidebar-widget-height mb-20">
                                        <h4 class="sidebar-widget-title widget-title-font-dec">Categories </h4>
                                        <div class="sidebar-categories-list">
                                            <ul>
                                                <li><a href="#">Accessories <span>(5)</span></a></li>
                                                <li><a href="#">Blood Pressure <span>(5)</span></a></li>
                                                <li><a href="#">Facemask <span>(3)</span></a></li>
                                                <li><a href="#"> Medical Supplies <span>(14)</span> </a></li>
                                                <li><a href="#">Hospital Equipment <span>(18)</span> </a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-width-16-2 custom-common-column">
                                    <div class="sidebar-widget sidebar-widget-height mb-20">
                                        <h4 class="sidebar-widget-title widget-title-font-dec">Price Filter </h4>
                                        <div class="sidebar-price-filter-list">
                                            <ul>
                                                <li><a href="#">All</a></li>
                                                <li><a href="#">$0.00 - $20.00 </a></li>
                                                <li><a href="#">$20.00 - $40.00 </a></li>
                                                <li><a href="#">$40.00 - $60.00 </a></li>
                                                <li><a href="#">$60.00 - $80.00 </a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-width-16-2 custom-common-column">
                                    <div class="sidebar-widget sidebar-widget-height mb-20">
                                        <h4 class="sidebar-widget-title widget-title-font-dec">Reviews </h4>
                                        <div class="sidebar-rating-list">
                                            <ul>
                                                <li>
                                                    <a href="#"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i> <span> (7)</span></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="gray far fa-star"></i> <span> (2)</span></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="gray far fa-star"></i><i class="gray far fa-star"></i> <span> (2)</span></a>
                                                </li>
                                                <li>
                                                    <a href="#"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="gray far fa-star"></i><i class="gray far fa-star"></i><i class="gray far fa-star"></i> <span> (1)</span></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-width-16-2 custom-common-column">
                                    <div class="sidebar-widget sidebar-widget-height mb-20">
                                        <h4 class="sidebar-widget-title widget-title-font-dec">Colors </h4>
                                        <div class="sidebar-color-list tooltip-style-3">
                                            <ul>
                                                <li><a aria-label="Black" class="black" href="#">black</a></li>
                                                <li><a aria-label="Blue" class="blue" href="#">blue</a></li>
                                                <li><a aria-label="Green" class="green" href="#">green</a></li>
                                                <li><a aria-label="Pink" class="pink" href="#">pink</a></li>
                                                <li><a aria-label="Powder blue" class="powder-blue" href="#">powder-blue</a></li>
                                                <li><a aria-label="Purple" class="purple" href="#">purple</a></li>
                                                <li><a aria-label="Red" class="red" href="#">red</a></li>
                                                <li><a aria-label="Transparent" class="transparent" href="#">transparent</a></li>
                                                <li><a aria-label="White" class="white" href="#">white</a></li>
                                                <li><a aria-label="Yellow" class="yellow" href="#">yellow</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-width-16-2 custom-common-column">
                                    <div class="sidebar-widget sidebar-widget-height mb-20">
                                        <h4 class="sidebar-widget-title widget-title-font-dec">Brands </h4>
                                        <div class="sidebar-brand-list">
                                            <ul>
                                                <li><a href="#">Allergy Clinic <span>(6)</span></a></li>
                                                <li><a href="#">Axs Health <span>(5)</span></a></li>
                                                <li><a href="#">BioZen <span>(6)</span></a></li>
                                                <li><a href="#">Caravus <span>(4)</span></a></li>
                                                <li><a href="#">Health Care <span>(5)</span></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="shop-bottom-area">
                            <div class="row">
                            
                            <c:forEach items="${listProduct}" var = "list" varStatus="status">
                                <div class="custom-col-5 wow tmFadeInUp" style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
                                    <div class="single-product-wrap mb-50">
                                        <div class="product-img-action-wrap mb-10">
                                            <div class="product-img product-img-zoom">
                                                <a href="/product/${list.channel_id}/${list.product_id}">
                                                    <img class="default-img" src="/product/display?filename=${list.product_img}" alt="">
                                                    <img class="hover-img" src="/product/display?filename=${list.product_img}" alt="">
                                                </a>
                                            </div>
                                            <div class="product-action-1">
                                                <button aria-label="쇼핑카트 추가"><i class="far fa-shopping-bag"></i></button>
                                                <button aria-label="좋아요"><i class="far fa-heart"></i></button>\
                                            </div>
                                            <div class="product-badges product-badges-position product-badges-mrg">
                                                <span class="red-2"> - <c:out value="${list.discount}" />%</span>
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
                            </c:forEach>
                                
                            
							
							<div class="pro-details-action-wrap">
                                 <div class="pro-details-add-to-cart">
                                 	<form name="regit" action="/product/registform" method="get">
										<button type="submit">상품 등록</button>
									</form>
                                 </div>
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