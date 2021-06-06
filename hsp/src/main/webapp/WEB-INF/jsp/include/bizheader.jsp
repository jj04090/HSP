<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

	<style>
	.image_container img { margin:20px 0; }
	.small1 { width: 400px; }
	.small2 { height: 400px; }
	</style>
	
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> HSP - Home Meal Replacement </title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="Add_Description_Text">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="/resources/ckeditor/ckeditor.js"></script>
    <link rel="profile" href="https://gmpg.org/xfn/11">
    <link rel="canonical" href="Replace_with_your_PAGE_URL" />

    <!-- Open Graph (OG) meta tags are snippets of code that control how URLs are displayed when shared on social media  -->
    <meta property="og:locale" content="en_US" />
    <meta property="og:type" content="website" />
    <meta property="og:title" content="Add a Title" />
    <meta property="og:url" content="Replace_with_your_PAGE_URL" />
    <meta property="og:site_name" content="SITE_NAME" />
    <!-- For the og:image content, replace the # with a link of an image -->
    <meta property="og:image" content="#" />
    <meta property="og:description" content="Add_Description_Text" />
    <!-- Add site Favicon -->
    <link rel="icon" href="/assets/images/favicon/cropped-favicon-32x32.png" sizes="32x32" />
    <link rel="icon" href="/assets/images/favicon/cropped-favicon-192x192.png" sizes="192x192" />
    <link rel="apple-touch-icon" href="/assets/images/favicon/cropped-favicon-180x180.png" />
    <meta name="msapplication-TileImage" content="/assets/images/favicon/cropped-favicon-270x270.png" />

    <!-- All CSS is here
	============================================ -->

    <link rel="stylesheet" href="/assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/vendor/font-cerebrisans.css">
    <link rel="stylesheet" href="/assets/css/vendor/fontawesome-all.min.css">
    <link rel="stylesheet" href="/assets/css/vendor/font-medizin.css">
    <link rel="stylesheet" href="/assets/css/plugins/slick.css">
    <link rel="stylesheet" href="/assets/css/plugins/animate.css">
    <link rel="stylesheet" href="/assets/css/plugins/magnific-popup.css">
    <link rel="stylesheet" href="/assets/css/plugins/select2.min.css">
    <link rel="stylesheet" href="/assets/css/plugins/jquery-ui.css">
    <link rel="stylesheet" href="/assets/css/style.css">

    <script type="application/ld+json">
        {
            "@context": "http://schema.org",
            "@type": "WebSite",
            "name": "Medizin - Medical Equipment eCommerce HTML Template",
            "url": "https://rundemo.moveaddons.com/medizin/index.html"
        }
    </script>

</head>

<body>

    <div class="main-wrapper">
        <header class="header-area header-height-1">
            <div class="header-top header-top-ptb-1 bg-gray d-none d-lg-block">
                <div class="custom-container">
                    <div class="row align-items-center">
                        <div class="col-xl-3 col-lg-4">
                            <div class="header-info">
                                <ul>
                                    <li><a href="#">캡스톤 프로젝트</a></li>
                                    <li><a target="_blank" href="https://www.google.com/maps">선문대학교</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-4">
                            <div class="covid-update text-center">
                                <p><a href="#">사업자 관리 화면</a> 자신의 채널을 관리하세요</p>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-4">
                            <div class="header-info header-info-right">
                                <ul>
                                    <li>
                                        <a class="language-dropdown-active" href="#">한국어 <i class="fa fa-chevron-down"></i></a>
                                        <ul class="language-dropdown">
                                            <li><a href="#">English</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                    	<c:choose>
                                    		<c:when test="${user_name ne null}">
                                    			<a href="/user">${user_name}님</a>
                                    			/
                                    			<a href="/logout">로그아웃</a>
                                    		</c:when>
                                    		
                                    		<c:otherwise>
                                    			<a href="/login">로그인</a>
                                    			/
                                    			<a href="/user/regist"> 회원 가입</a>
                                    		</c:otherwise>
                                    	</c:choose>
                                    	
                                    	
                                    	
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom sticky-bar sticky-white-bg">
                <div class="custom-container">
                    <div class="header-wrap header-space-between position-relative">
                        <div class="logo logo-width-1">
                            <a href="/main"><img src="/assets/images/logo/logo.png" alt="logo"></a>
                        </div>
                        <div class="main-menu main-menu-padding-1 main-menu-lh-1 d-none d-lg-block hover-boder">
                            <nav>
                                <ul>
                                    <li><a class="active" href="/main">Home <i class="fa fa-chevron-down"></i></a>
                                        
                                    </li>
                                    <li><a href="/channel">채널 관리 <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="/channel">채널의 정보를 관리하세요!</a></li>
                                        </ul>
                                    </li>
                                    
                                    
                                    <li class="position-static"><a href="/order">주문 관리 <i class="fa fa-chevron-down"></i></a>
                                        <ul class="mega-menu">
                                            <li class="sub-mega-menu sub-mega-menu-width-22">
                                                <a class="menu-title" href="#">주문된 상품을 처리하세요!</a>
                                                
                                            </li>
                                            
                                         </ul>
                                    </li>
                                    
                                    <li><a href="/product">상품 관리 <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="/product">자신의 상품을 관리하세요!</a></li>
                                            
                                        </ul>
                                    </li>
                                    
                                    <!-- 세션에서 추가하는걸로 -->
                                    <li><a href="/community/${channel_id}">커뮤니티 관리 <i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="blog.html">커뮤니티 게시글 관리하세요!</a></li>
                                            
                                        </ul>
                                    </li>
                                    
                                    
                                    <li><a href="contact-us.html">Contact</a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="header-action-right">
                            <div class="header-action">
                                
                                
                                
                                <div class="header-action-icon d-block d-lg-none">
                                    <div class="burger-icon">
                                        <span class="burger-icon-top"></span>
                                        <span class="burger-icon-bottom"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>