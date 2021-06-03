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
                        <li class="active"> 상품 수정 </li>
                    </ul>
                </div>
            </div>
    </div>
	
	
	<div class="login-register-area pt-75 pb-75">
		<div class="container">
		
		
		<div class="wishlist-area pt-75 pb-75">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <form action="#">
                            <div class="wishlist-table-content">
                                <div class="table-content table-responsive">
                                    <table>
                                        <tbody>
                                        
                                        <c:forEach items="${ordersList}" var = "list" varStatus="status">
                                            <tr>
                                                <td class="wishlist-product-thumbnail">
                                                    <a href="#"><i class="far fa-times"></i></a>
                                                </td>
                                                <td class="wishlist-product-img">
                                                    <a href="product-details.html"><img src="assets/images/cart/cart-1.jpg" alt=""></a>
                                                </td>
                                                <td class="wishlist-product-info">
                                                    <h5><a href="/order/${list.order_id}"> <c:out value="${list.order_id}" /> </a></h5>
                                                    <div class="wishlist-product-price">
                                                        <span class="new-price">
                                                        	<c:if test="${list.order_type == 'S'}">일반상품</c:if>
															<c:if test="${list.order_type == 'W'}">정기상품</c:if>
                                                        </span>
                                                    </div>
                                                    <span><c:out value="${list.order_date}" /></span>
                                                </td>
                                                <td class="wishlist-product-add-wrap">
                                                    <span><c:out value="${list.order_status}" /></span>
                                                    <div class="wishlist-product-add">
                                                        <a href="#">Add to cart</a>
                                                        <a href="#">Add to cart</a>
                                                        
                                                        <c:if test="${user_type == 'C'}">
		
														<c:if test="${list.order_type == 'W' && list.order_status == 'O'}">
															<div>
																<form name="schedualCancel" action="/order/cancelschedual/${list.order_id}" method="get">
																	<button type="submit">정기 주문 취소</button>
																</form>
															</div>
														</c:if>
																		<!-- a테그로 해결해야됨 -->
														<c:if test="${cancelAble[status.index] == 'Y'}">
															<div>
																<form name="orderCancel" action="/order/cancel/${list.order_id}" method="get">
																	<button type="submit">주문 취소</button>
																</form>
															</div>
														</c:if>
													
													</c:if>
                                                        
                                                    </div>
                                                </td>
                                            </tr>
                                            </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </form>
                        <div class="wishlist-bottom">
                            <div class="wishlist-social-wrap">
                                <span>Share on:</span>
                                <div class="wishlist-social">
                                    <a href="#">Facebook</a>
                                    <a href="#">Twitter</a>
                                    <a href="#">Pinterest</a>
                                    <a href="#">Mail</a>
                                </div>
                            </div>
                            <div class="wishlist-link">
                                <span>Wishlist link:</span>
                                <div class="wishlist-input-wrap">
                                    <div class="wishlist-input">
                                        <input id="copy" type="url" value="https://bootstrap.hasthemes.com/">
                                    </div>
                                    <div class="wishlist-btn"><a class="cbtn" data-clipboard-action="copy" data-original-title="Copied!" data-clipboard-target="#copy">Copy</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		
		
		
		
		
		
		
	
	<c:forEach items="${ordersList}" var = "list" varStatus="status">
		<ul>
			<li> 주문 ID : <a href="/order/${list.order_id}"> <c:out value="${list.order_id}" /> </a> </li>
			<li>주문 종류 : 
				<c:if test="${list.order_type == 'S'}">일반상품</c:if>
				<c:if test="${list.order_type == 'W'}">정기상품</c:if>
			</li>
			<li>주문 일자 : <c:out value="${list.order_date}" /> </li>
			<li>결제 상태 : <c:out value="${list.order_status}" /> </li>
		
		<c:if test="${user_type == 'C'}">
		
			<c:if test="${list.order_type == 'W' && list.order_status == 'O'}">
				<div>
					<form name="schedualCancel" action="/order/cancelschedual/${list.order_id}" method="get">
						<button type="submit">정기 주문 취소</button>
					</form>
				</div>
			</c:if>
		
			<c:if test="${cancelAble[status.index] == 'Y'}">
				<div>
					<form name="orderCancel" action="/order/cancel/${list.order_id}" method="get">
						<button type="submit">주문 취소</button>
					</form>
				</div>
			</c:if>
		
		</c:if>
		
		</ul>
		
	</c:forEach>
	
		</div>
	</div>
	
<%@ include file="../include/footer.jsp"%>
</body>
</html>