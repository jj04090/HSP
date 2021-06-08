<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>

<div class="slider-banner-area padding-10-row-col">
	<div class="custom-container">
		<div class="row">
			<div
				class="custom-common-column custom-column-width-66 custom-padding-5">
				<div class="slider-area">
					<div
						class="hero-slider-active-1 nav-style-1 nav-style-1-position-1 slick-initialized slick-slider">
						<div class="slick-list draggable">
							<div class="slick-track" style="opacity: 1; width: 2832px;">
								<div
									class="single-hero-slider single-animation-wrap slider-height-1 custom-d-flex custom-align-item-end bg-img slick-slide slick-current slick-active"
									style="background-image: url(&quot;assets/images/mainn.jpg&quot;); width: 944px; position: relative; left: 0px; top: 0px; z-index: 999; opacity: 1;"
									data-slick-index="0" aria-hidden="false" tabindex="0">
									<div class="hero-slider-content-1 slider-animated-1">
										<div
											style="background-color: #000000; background-color: rgba(255, 255, 255, 0.8); padding: 0 50px 20px 50px;">
											<h1 style="padding: 50px 0; font-weight: bold; color: black;"
												class="animated">
												HMR 식품을 간편하게 구입하세요 <br>&amp; 간편식품
											</h1>
											<p style="font-weight: bold; color: black;" class="animated">채널
												구독을 통하여 할인을 받고 구매하세요! 정기 주문도 가능합니다!</p>
										</div>
										<div style="padding-top: 10px; float: right;"
											class="btn-style-1">
											<a class="animated" href="/product" tabindex="0"> 상품 보기 </a>
										</div>
									</div>
									<div
										class="slider-product-price slider-product-position1 slider-animated-1 animated">
										<h3>
											<span>HMR</span> Easy
										</h3>
									</div>
								</div>
								<div
									class="single-hero-slider single-animation-wrap slider-height-1 custom-d-flex custom-align-item-end slick-slide"
									style="background-image: url(&quot;assets/images/slider/hm1-slider-2.jpg&quot;); width: 944px; position: relative; left: -944px; top: 0px; z-index: 998; opacity: 0;"
									data-slick-index="1" aria-hidden="true" tabindex="-1">
									<div
										class="hero-slider-content-1 slider-content-1-black slider-animated-1">
										<h4 class="animated">Best selling</h4>
										<h1 class="animated">
											COVID-19 Prevention <br>&amp; Care Supplies
										</h1>
										<p class="animated">Backed by experience since 1950.
											One-stop Source for all your Hospital &amp; Medical Needs.</p>
										<div class="btn-style-1">
											<a class="animated" href="product-details.html" tabindex="-1">
												Buy now </a>
										</div>
									</div>
									<div
										class="slider-product-price slider-product-position1 slider-animated-1 animated">
										<h3>
											<span>From</span> $5*
										</h3>
									</div>
								</div>
								<div
									class="single-hero-slider single-animation-wrap slider-height-1 custom-d-flex custom-align-item-end slick-slide"
									style="background-image: url(&quot;assets/images/slider/hm1-slider-3.jpg&quot;); width: 944px; position: relative; left: -1888px; top: 0px; z-index: 998; opacity: 0;"
									data-slick-index="2" aria-hidden="true" tabindex="-1">
									<div class="hero-slider-content-1 slider-animated-1">
										<div class="slider-product-offer-wrap animated">
											<div class="slider-product-offer">
												<span class="yellow">hot </span> <span class="red">-28%
												</span>
											</div>
											<p>3M 6000 Series</p>
										</div>
										<h1 class="animated">
											Fitted Face Mask N95<br> Group Pack of 3
										</h1>
										<p class="animated">3M high-efficiency electrostatic
											filter cotton, non-oily particle filtration efficiency ≥ 90%
										</p>
										<div class="btn-style-1">
											<a class="animated" href="product-details.html" tabindex="-1">
												Buy now </a>
										</div>
									</div>
									<div
										class="slider-product-price slider-product-position2 slider-animated-1 animated">
										<h3>
											<span>Only </span> $18
										</h3>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
			<div
				 class="custom-common-column custom-column-width-33 custom-padding-5" >
				<div  class="banner-area banner-area-mt">
					<div class="row">
						<div class="col-xl-12 col-lg-6 col-md-6 col-12 col-sm-12">
							<div class="banner-wrap wow tmFadeInUp mb-10"
								style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
								<div class="banner-img banner-img-zoom">
									<a href="product-details.html"><img
										src="/product/display?filename=${grade.product_img}" alt=""
										height="252" width="480"></a>
								</div>
								<div class="banner-content-1">
								<div
											style="background-color: #000000; background-color: rgba(255, 255, 255, 0.8); padding: 10px 20px 0 20px;">
									<span style="font-weight: bold">가장 평점이 좋은 상품</span>
									<h2 style="font-weight: bold">${grade.product_name}</h2>
									<h3 style="font-weight: bold"><fmt:formatNumber value="${grade.product_price}" pattern="#,###" /> 원</h3>
									</div>
									<div class="btn-style-1">
										<a class="font-size-14 btn-1-padding-2"
											href="product-details.html">Shop now </a>
									</div>
								</div>

								<div class="banner-badge banner-badge-position2">
									<h3>
										<span>Best</span> Review
									</h3>
								</div>

							</div>
						</div>
						<div class="col-xl-12 col-lg-6 col-md-6 col-12 col-sm-12">
							<div class="banner-wrap wow tmFadeInUp mb-10"
								style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
								<div class="banner-img banner-img-zoom">
									<a href="product-details.html"><img
										src="/product/display?filename=${ordered.product_img}" alt=""
										height="252" width="480"></a>
								</div>
								<div class="banner-content-1">
								<div
											style="background-color: #000000; background-color: rgba(255, 255, 255, 0.8); padding: 10px 20px 0 20px;">
									<span style="font-weight: bold;">많은 사람들이 구매한 상품</span>
									<h2>${ordered.product_name}</h2>
									<h3><fmt:formatNumber value="${ordered.product_price}" pattern="#,###" /> 원</h3>
									</div>
									<div class="btn-style-1">
										<a class="font-size-14 btn-1-padding-2"
											href="/product/${ordered.channel_id}/${ordered.product_id}">Shop
											now </a>
									</div>
								</div>
								<div class="banner-badge banner-badge-position2">
									<h3>
										<span>Best</span> Selling
									</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<br>

<div class="product-area pb-20">
	<div class="custom-container">
		<div class="section-title-btn-wrap mb-40 wow tmFadeInUp"
			style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
			<div class="section-title-1">
				<h2>가장 인기있는 상품</h2>
			</div>
			<div class="btn-style-2 mrg-top-xs">
				<a href="/product">더 많은 상품을 만나보세요! <i
					class="far fa-long-arrow-right"></i></a>
			</div>
		</div>
		<div class="row">

			<c:forEach items="${sellingList}" var="list" varStatus="status">

				<div class="custom-col-5">
					<div class="single-product-wrap mb-50 wow tmFadeInUp"
						style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
						<div class="product-img-action-wrap mb-20">
							<div class="product-img product-img-zoom">
								<a href="/product/${list.channel_id}/${list.product_id}"> <img
									class="default-img"
									src="/product/display?filename=${list.product_img}" alt="">
									<img class="hover-img"
									src="/product/display?filename=${list.product_img}" alt="">
								</a>
							</div>
							<div class="product-action-1">
								<button aria-label="장바구니 추가">
									<i class="far fa-shopping-bag"></i>
								</button>
								<button aria-label="좋아요">
									<i class="far fa-heart"></i>
								</button>
							</div>
							<div
								class="product-badges product-badges-position product-badges-mrg">
								<span class=" red">구독시 -${list.discount}%</span>
							</div>
						</div>
						<div class="product-content-wrap">
							<h2>
								<a href="/product/${list.channel_id}/${list.product_id}">${list.product_name}</a>
							</h2>
							<div class="product-price">
								<span class="new-price"><fmt:formatNumber
										value="${discount[status.index]}" pattern="#,###" /> 원</span> <span
									class="old-price"><fmt:formatNumber
										value="${list.product_price}" pattern="#,###" /> 원</span>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>

		</div>
	</div>
</div>

<div class="product-area pb-20">
	<div class="custom-container">
		<div class="section-title-btn-wrap mb-40 wow tmFadeInUp"
			style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
			<div class="section-title-1">
				<h2>인기 있는 채널</h2>
			</div>
			<div class="btn-style-2 mrg-top-xs">
				<a href="/channel">더 많은 채널을 만나보세요! <i
					class="far fa-long-arrow-right"></i></a>
			</div>
		</div>
		<div class="row">

			<c:forEach items="${topChannel}" var="toplist" varStatus="status">

				<div class="custom-col-5">
					<div class="single-product-wrap mb-50 wow tmFadeInUp"
						style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
						<div class="product-img-action-wrap mb-20">
							<div class="product-img product-img-zoom">
								<a href="/product/${list.channel_id}/${list.product_id}"> <img
									class="default-img"
									src="/channel/display?filename=${toplist.channel_img}" alt="">
									<img class="hover-img"
									src="/channel/display?filename=${toplist.channel_img}" alt="">
								</a>
							</div>
							<div class="product-action-1">
								<button aria-label="구독하기">
									<i class="far fa-heart"></i>
								</button>
							</div>
							<div
								class="product-badges product-badges-position product-badges-mrg">
								<span class=" red">HOT</span>
							</div>
						</div>
						<div class="product-content-wrap">
							<h2>
								<a href="/product/${list.channel_id}/${list.product_id}">${toplist.channel_name}</a>
							</h2>
							<div class="product-price">
								<span class="new-price"> ${count[status.index]}</span> <span
									class="new-price"> 구독자 </span>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>

		</div>
	</div>
</div>




<%@ include file="../include/footer.jsp"%>
</body>
</html>