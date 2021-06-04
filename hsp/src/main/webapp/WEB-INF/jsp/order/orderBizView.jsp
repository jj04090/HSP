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
                        <li class="active"> 사업자 주문 관리 </li>
                    </ul>
                </div>
            </div>
        </div>
	
	<div class="checkout-area pt-75 pb-75">
            <div class="container">
                <div class="row">
                    <div class="col-lg-7">
                        <div class="customer-zone padding-20-row-col mb-10">
                            <p class="cart-page-title">Returning customer? <a class="checkout-click1" href="#">Click here to login</a></p>
                            <div class="checkout-login-info">
                                <p>If you have shopped with us before, please enter your details below. If you are a new customer, please proceed to the Billing section.</p>
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="sin-checkout-login input-style mrg-small-device">
                                                <label>Username or email *</label>
                                                <input type="text" name="user-name">
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="sin-checkout-login input-style">
                                                <label>Password *</label>
                                                <input type="password" name="user-password">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="button-remember-wrap">
                                        <div class="checkout-login-toggle-btn">
                                            <input type="checkbox">
                                            <label>Remember me</label>
                                        </div>
                                        <button class="button" type="submit">Login</button>
                                    </div>
                                    <div class="lost-password">
                                        <a href="#">Lost your password?</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                        
                        <div class="billing-info-wrap padding-20-row-col">
                            <h3>소비자 주소</h3>
                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="billing-info input-style mb-35">
                                        <label>First Name *</label>
                                        <input type="text" placeholder="First Name">
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6">
                                    <div class="billing-info input-style mb-35">
                                        <label>Last Name *</label>
                                        <input type="text" placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>Company Name *</label>
                                        <input type="text" placeholder="Company Name">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="select-style billing-select mb-35">
                                        <label>Country *</label>
                                        <select class="select-active select2-hidden-accessible" data-select2-id="1" tabindex="-1" aria-hidden="true">
                                            <option data-select2-id="3">United States (US)</option>
                                            <option>Uganda</option>
                                            <option>Ukraine</option>
                                            <option>Bangladesh</option>
                                            <option>Barbados</option>
                                        </select><span class="select2 select2-container select2-container--default" dir="ltr" data-select2-id="2" style="width: 670px;"><span class="selection"><span class="select2-selection select2-selection--single" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="0" aria-labelledby="select2-7h9j-container"><span class="select2-selection__rendered" id="select2-7h9j-container" role="textbox" aria-readonly="true" title="United States (US)">United States (US)</span><span class="select2-selection__arrow" role="presentation"><b role="presentation"></b></span></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>Street Address *</label>
                                        <input class="billing-address" placeholder="House number and street name" type="text">
                                        <input placeholder="Apartment, suite, unit, etc. (optional)" type="text">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>Town / City *</label>
                                        <input type="text" placeholder="Town / City ">
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>State *</label>
                                        <input type="text" placeholder="State">
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>ZIP *</label>
                                        <input type="text" placeholder="ZIP">
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>Phone *</label>
                                        <input type="text" placeholder="Phone">
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12">
                                    <div class="billing-info input-style mb-35">
                                        <label>Email Address *</label>
                                        <input type="email" placeholder="Email Address">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout-account">
                                <input class="checkout-toggle2" type="checkbox">
                                <span>Create an account?</span>
                            </div>
                            <div class="checkout-account-toggle open-toggle2">
                                <div class="input-style mb-35">
                                    <label>Account username </label>
                                    <input placeholder="Username" type="email">
                                </div>
                                <div class="input-style">
                                    <label>Create account password </label>
                                    <input placeholder="Password" type="password">
                                </div>
                            </div>
                            <div class="different-address mt-35">
                                <input class="checkout-toggle" type="checkbox">
                                <span>Ship to a different address?</span>
                            </div>
                            <div class="different-address open-toggle mt-35">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <div class="billing-info input-style mb-35">
                                            <label>First Name *</label>
                                            <input type="text" placeholder="First Name">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6">
                                        <div class="billing-info input-style mb-35">
                                            <label>Last Name *</label>
                                            <input type="text" placeholder="Last Name">
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>Company Name *</label>
                                            <input type="text" placeholder="Company Name">
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="select-style billing-select mb-35">
                                            <label>Country *</label>
                                            <select class="select-active select2-hidden-accessible" data-select2-id="4" tabindex="-1" aria-hidden="true">
                                                <option data-select2-id="6">United States (US)</option>
                                                <option>Uganda</option>
                                                <option>Ukraine</option>
                                                <option>Bangladesh</option>
                                                <option>Barbados</option>
                                            </select><span class="select2 select2-container select2-container--default" dir="ltr" data-select2-id="5" style="width: auto;"><span class="selection"><span class="select2-selection select2-selection--single" role="combobox" aria-haspopup="true" aria-expanded="false" tabindex="0" aria-labelledby="select2-ak8b-container"><span class="select2-selection__rendered" id="select2-ak8b-container" role="textbox" aria-readonly="true" title="United States (US)">United States (US)</span><span class="select2-selection__arrow" role="presentation"><b role="presentation"></b></span></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>Street Address *</label>
                                            <input class="billing-address" placeholder="House number and street name" type="text">
                                            <input placeholder="Apartment, suite, unit, etc. (optional)" type="text">
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>Town / City *</label>
                                            <input type="text" placeholder="Town / City ">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>State *</label>
                                            <input type="text" placeholder="State">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>ZIP *</label>
                                            <input type="text" placeholder="ZIP">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>Phone *</label>
                                            <input type="text" placeholder="Phone">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-12">
                                        <div class="billing-info input-style mb-35">
                                            <label>Email Address *</label>
                                            <input type="email" placeholder="Email Address">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="additional-info-wrap">
                                <label>Order notes (optional)</label>
                                <textarea placeholder="Notes about your order, e.g. special notes for delivery." name="message"></textarea>
                            </div>
                        </div>
                        <div class="payment-details-area">
                            <h4>Payment information</h4>
                            <div class="payment-method">
                                <div class="sin-payment payment-selected mb-20">
                                    <input id="payment_method_1" class="input-radio" type="radio" value="cheque" checked="checked" name="payment_method">
                                    <label for="payment_method_1">
                                        <span>
                                        <img class="nomal-img" src="assets/images/icon-img/direct-bank.png" alt="">
                                        <img class="active-img" src="assets/images/icon-img/direct-bank-active.png" alt="">
                                    </span>
                                        Direct bank transfer
                                    </label>
                                    <div class="payment-box payment_method_bacs" style="display: block;">
                                        <p>Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order will not be shipped until the funds have cleared in our account.</p>
                                    </div>
                                </div>
                                <div class="sin-payment mb-20">
                                    <input id="payment-method-2" class="input-radio" type="radio" value="cheque" name="payment_method">
                                    <label for="payment-method-2">
                                        <span>
                                        <img class="nomal-img" src="assets/images/icon-img/check-payments.png" alt="">
                                        <img class="active-img" src="assets/images/icon-img/check-payments-active.png" alt="">
                                    </span>
                                        Check payments
                                    </label>
                                    <div class="payment-box payment_method_bacs">
                                        <p>Please send a check to Store Name, Store Street, Store Town, Store State / County, Store Postcode.</p>
                                    </div>
                                </div>
                                <div class="sin-payment mb-20">
                                    <input id="payment-method-3" class="input-radio" type="radio" value="cheque" name="payment_method">
                                    <label for="payment-method-3">
                                        <span>
                                        <img class="nomal-img" src="assets/images/icon-img/cash-on-delivery.png" alt="">
                                        <img class="active-img" src="assets/images/icon-img/cash-on-delivery-active.png" alt="">
                                    </span>
                                        Cash on delivery
                                    </label>
                                    <div class="payment-box payment_method_bacs">
                                        <p>Pay with cash upon delivery.</p>
                                    </div>
                                </div>
                                <div class="sin-payment">
                                    <input id="payment-method-4" class="input-radio" type="radio" value="cheque" name="payment_method">
                                    <label for="payment-method-4">
                                        <span>
                                        <img class="nomal-img" src="assets/images/icon-img/paypal.png" alt="">
                                        <img class="active-img" src="assets/images/icon-img/paypal-active.png" alt="">
                                    </span>
                                        PayPal
                                    </label>
                                    <div class="payment-box payment_method_bacs">
                                        <p>Pay via PayPal; you can pay with your credit card if you don’t have a PayPal account.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="order-summary">
                            <div class="order-summary-title">
                                <h3>주문 목록</h3>
                            </div>
                            
                            <c:forEach items="${orderInfoList}" var = "orderInfo">
                            <div class="order-summary-top">
                                <div class="order-summary-img-price">
                                    <div class="order-summary-img-title">
                                        <div class="order-summary-img">
                                            <a href="product-details.html"><img src="assets/images/cart/cart-1.jpg" alt=""></a>
                                        </div>
                                        <div class="order-summary-title">
                                            <h4>Surgical Latex Gloves <span>× 1</span></h4>
                                        </div>
                                    </div>
                                    <div class="order-summary-price">
                                        <span>$120.00</span>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            
                            <div class="order-summary-middle">
                                <ul>
                                    <li>Subtotal <h4>$180.00</h4>
                                    </li>
                                    <li>Shipping <h4><span>Flat rate:</span><span class="price">$5.00</span></h4>
                                    </li>
                                </ul>
                            </div>
                            <div class="order-summary-bottom">
                                <h4>Total <span>$185.00</span></h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	
	<c:forEach items="${orderInfoList}" var = "orderInfo">
	
	<ul>
			<li>주문 ID : ${orderInfo.order_id} </li>
			<li>상품 종류 : <c:if test="${orderInfo.order_type == 'S'}">일반상품</c:if>
					  <c:if test="${orderInfo.order_type == 'W'}">정기상품</c:if> 
			</li>
			<li>상품 명 : ${orderInfo.product_name} </li>
			<li>상품 사진 : <img class='small1' src="/product/display?filename=${orderInfo.product_img}"> </li>
			<li>상품 ID : ${orderInfo.product_id} </li>
			<li>상품 개수 : ${orderInfo.product_qty} </li>
			<li>상품 가격 : ${orderInfo.price} </li>
			<li>상품 할인율 : ${orderInfo.discount} % </li> 
			<li>주소 : ${orderInfo.address} </li>
			<li>상세 주소 : ${orderInfo.detail_add} </li>
			<li>우편 번호 : ${orderInfo.zip_code} </li>
			
			<li>주문 상태 :
				<c:if test="${orderInfo.delevery_status == 'O'}">주문완료</c:if>
				<c:if test="${orderInfo.delevery_status == 'D'}">배송중</c:if> 
				<c:if test="${orderInfo.delevery_status == 'C'}">배송완료</c:if>
				<c:if test="${orderInfo.delevery_status == 'R'}">반품중</c:if> 
				<c:if test="${orderInfo.delevery_status == 'F'}">반품완료</c:if>
				<c:if test="${orderInfo.delevery_status == 'N'}">반품거부</c:if> 
			</li>
			
	</ul>
	
	<div>
			<form name="change" action="/order/change" method="post">
				<input type="hidden" name="_method" value="PUT" />
					
				<input type="hidden" name="order_id" value="${orderInfo.order_id}">
				<input type="hidden" name="product_id" value="${orderInfo.product_id}">
					
				<c:if test="${orderInfo.delevery_status == 'O'}">
					<button type="submit" name="delevery_status" value="D">배송 등록</button>
				</c:if>
					
				<c:if test="${orderInfo.delevery_status == 'R'}">
					<button type="submit" name="delevery_status" value="F">반품 완료</button>
					<button type="submit" name="delevery_status" value="N">반품 거부</button>
				</c:if>
			</form>
	</div>
	
	</c:forEach>
	
<%@ include file="../include/bizfooter.jsp"%>
</body>
</html>
