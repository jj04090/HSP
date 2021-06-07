<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/bizheader.jsp"%>

<div class="slider-banner-area padding-10-row-col">
	<div class="custom-container">
		<div class="row">
			<div
				class="custom-common-column custom-column-width-66 custom-padding-5">
				<div class="slider-area">
					<div
						class="hero-slider-active-1 nav-style-1 nav-style-1-position-1 slick-initialized slick-slider">

						<div class="slick-list draggable">
							<div class="slick-track" style="opacity: 1; width: 2331px;">
								<div
									class="single-hero-slider single-animation-wrap slider-height-1 custom-d-flex custom-align-item-end bg-img slick-slide slick-current slick-active"
									style="background-image: url(&quot;assets/images/slider/hm1-slider-1.jpg&quot;); width: 777px; position: relative; left: 0px; top: 0px; z-index: 999; opacity: 1;"
									data-slick-index="0" aria-hidden="false" tabindex="0">
									<div class="hero-slider-content-1 slider-animated-1">
										<h1 class="animated">
											사업자 관리 화면 <br>&amp; 채널과 상품을 관리하세요
										</h1>
										<p class="animated">많은 기능 제공을 위해 발전 중입니다.</p>
										<div class="btn-style-1">
											<a class="animated" href="product-details.html" tabindex="0">
												채널 관리 </a>
										</div>
									</div>
									<div
										class="slider-product-price slider-product-position1 slider-animated-1 animated">
										<h3>
											<span>구독자</span> ${count}명
										</h3>
									</div>
								</div>
								<div
									class="single-hero-slider single-animation-wrap slider-height-1 custom-d-flex custom-align-item-end slick-slide"
									style="background-image: url(&quot;assets/images/slider/hm1-slider-2.jpg&quot;); width: 777px; position: relative; left: -777px; top: 0px; z-index: 998; opacity: 0;"
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
									style="background-image: url(&quot;assets/images/slider/hm1-slider-3.jpg&quot;); width: 777px; position: relative; left: -1554px; top: 0px; z-index: 998; opacity: 0;"
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
				class="custom-common-column custom-column-width-33 custom-padding-5">
				<div class="banner-area banner-area-mt">
					<div class="row">
						<div class="col-xl-12 col-lg-6 col-md-6 col-12 col-sm-12">
							<div class="banner-wrap wow tmFadeInUp mb-10"
								style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
								<div class="banner-img banner-img-zoom">
									<a href="product-details.html"><img
										src="assets/images/banner/banner-1.jpg" alt=""></a>
								</div>
								<div class="banner-content-1">
									<h2>계좌 등록/인증</h2>
									<h3>정산 서비스를 제공받으려면 &nbsp;&nbsp;&nbsp; 필수입니다!</h3>
									<div class="btn-style-1">
										<a class="font-size-14 btn-1-padding-2" onclick="auth_call();">계좌
											등록/인증 </a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-12 col-lg-6 col-md-6 col-12 col-sm-12">
							<div class="banner-wrap wow tmFadeInUp mb-10"
								style="visibility: visible; animation-name: medizinAnimationFadeInUp;">
								<div class="banner-img banner-img-zoom">
									<a href="/order"><img
										src="assets/images/banner/banner-2.jpg" alt=""></a>
								</div>
								<div class="banner-content-1">
									<h2>이번달 예상 수익</h2>
									<h3>
										<fmt:formatNumber value="${monthProfit}" pattern="#,###" />
										원
									</h3>
									<div class="btn-style-1">
										<a class="font-size-14 btn-1-padding-2" href="/order">주문
											목록 </a>
									</div>
								</div>

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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	function auth_call() {
		var tmpWindow = window.open('about:blank', '_blank',
				'width=500,height=600,top=60,left=500')
		tmpWindow.location = "https://testapi.openbanking.or.kr/oauth/2.0/authorize?"
				+ "response_type=code&"
				+ "client_id=728a9fc1-5d1d-4db9-b7e9-e9efcadf2f12&"
				+ // 
				"redirect_uri=http://localhost/certification&"
				+ "scope=login inquiry transfer&"
				+ "state=12345678901234567890123456789012&"
				+ "auth_type=0&"
				+ "authorized_cert_yn=N"
	}
</script>
</html>