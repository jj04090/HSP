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
		<div class="blog-details-area padding-30-row-col pt-75 pb-75">
            <div class="container">
                <div class="row flex-row-reverse">
                    <div class="col-lg-8">
	<div class="blog-details-wrapper">
                            <div class="blog-details-top-content">
                                
                                <h1>${community.community_title}</h1>
                                <div class="blog-meta-3">
                                    <ul>
                                        <li><a href="#"> 등록자</a> </li>
                                        <li><i class="far fa-calendar"></i> ${community.regit_date}</li>
                                    </ul>
                                </div>
                            </div>
                            <img src="/community/display?filename=${community.mediafile}" alt="">
                            
                            <p>${community.community_content}</p>
                            <div class="blog-details-middle-img">
                                
                            </div>
                            
                            
                            
                            
                            
                            
                            
                            <div class="blog-reply-wrapper">
                                
                                
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="input-style blog-input-style">
                                                
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="input-style blog-input-style">
                                                
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="textarea-style blog-textarea-style">
                                                
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="blog-comment-submit">
                                        <form name="edit" action="/${community.community_id}/editform" method="get">
											<button type="submit">게시글 수정</button>
										</form>
                                    </div>
                                </form>
                            </div>
                            <div class="blog-author-wrap">
		                        <c:forEach items="${listComment}" var = "list">
		                        	<div class="blog-author-wrap">
		                                <div class="blog-author-content">
		                                    <h4>${list.user_id}</h4>
		                                    <p>${list.comment_content}</p>
		                                </div>
		                            </div>
								</c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="sidebar-wrapper sidebar-wrapper-mr1">
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-2 mb-20">
                                <h4 class="sidebar-widget-title">Search </h4>
                                <div class="search-style-3">
                                    <form action="#">
                                        <input type="text" placeholder="Search…">
                                        <button type="submit"> <i class="far fa-search"></i> </button>
                                    </form>
                                </div>
                            </div>
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-1 mb-20">
                                <h4 class="sidebar-widget-title">Categories </h4>
                                <div class="sidebar-categories-list">
                                    <ul>
                                        <li><a href="blog.html">Daily LIfe <span>(8)</span></a></li>
                                        <li><a href="blog.html">Healthcare 5.0 <span>(1)</span></a></li>
                                        <li><a href="blog.html">Hot News <span>(4)</span></a></li>
                                        <li><a href="blog.html">Uncategorized <span>(2)</span></a></li>
                                        <li><a href="blog.html">Your Health <span>(3)</span></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-2 mb-20">
                                <h4 class="sidebar-widget-title">Popular posts </h4>
                                <div class="sidebar-post-wrap mt-30">
                                    <div class="single-sidebar-post">
                                        <div class="sidebar-post-img">
                                            <a href="blog-details.html"><img src="assets/images/blog/sidebar-blog-1.jpg" alt=""></a>
                                        </div>
                                        <div class="sidebar-post-content">
                                            <h4><a href="blog-details.html">Coronavirus latest: at a glance</a></h4>
                                            <span>April 21, 2020</span>
                                        </div>
                                    </div>
                                    <div class="single-sidebar-post">
                                        <div class="sidebar-post-img">
                                            <a href="blog-details.html"><img src="assets/images/blog/sidebar-blog-2.jpg" alt=""></a>
                                        </div>
                                        <div class="sidebar-post-content">
                                            <h4><a href="blog-details.html">Healthcare workers confronted anti-lockdown protesters</a></h4>
                                            <span>April 21, 2020</span>
                                        </div>
                                    </div>
                                    <div class="single-sidebar-post">
                                        <div class="sidebar-post-img">
                                            <a href="blog-details.html"><img src="assets/images/blog/sidebar-blog-3.jpg" alt=""></a>
                                        </div>
                                        <div class="sidebar-post-content">
                                            <h4><a href="blog-details.html">Turning crap into gold</a></h4>
                                            <span>April 21, 2020</span>
                                        </div>
                                    </div>
                                    <div class="single-sidebar-post">
                                        <div class="sidebar-post-img">
                                            <a href="blog-details.html"><img src="assets/images/blog/sidebar-blog-5.jpg" alt=""></a>
                                        </div>
                                        <div class="sidebar-post-content">
                                            <h4><a href="blog-details.html">WHO warns that few have developed antibodies to Covid-19</a></h4>
                                            <span>April 21, 2020</span>
                                        </div>
                                    </div>
                                    <div class="single-sidebar-post">
                                        <div class="sidebar-post-img">
                                            <a href="blog-details.html"><img src="assets/images/blog/sidebar-blog-4.jpg" alt=""></a>
                                        </div>
                                        <div class="sidebar-post-content">
                                            <h4><a href="blog-details.html">The stress of giving birth under lockdown</a></h4>
                                            <span>April 21, 2020</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="sidebar-widget sidebar-widget-wrap sidebar-widget-padding-6">
                                <h4 class="sidebar-widget-title">Popular tags </h4>
                                <div class="sidebar-tag">
                                    <ul>
                                        <li><a href="#">alzheimer</a></li>
                                        <li><a href="#">analytics</a></li>
                                        <li><a href="#">baby</a></li>
                                        <li><a href="#">corona virus</a></li>
                                        <li><a href="#">covid19</a></li>
                                        <li><a href="#">covid 19</a></li>
                                        <li><a href="#">daily</a></li>
                                        <li><a href="#">Daily Life</a></li>
                                        <li><a href="#">diet</a></li>
                                        <li><a href="#">elder</a></li>
                                        <li><a href="#">epedemic</a></li>
                                        <li><a href="#">happy life</a></li>
                                        <li><a href="#">health</a></li>
                                        <li><a href="#">healthy</a></li>
                                        <li><a href="#">hospital</a></li>
                                        <li><a href="#">hot news</a></li>
                                        <li><a href="#">life</a></li>
                                        <li><a href="#">mask</a></li>
                                        <li><a href="#">personal</a></li>
                                        <li><a href="#">quarantee</a></li>
                                        <li><a href="#">sickness</a></li>
                                        <li><a href="#">virus</a></li>
                                        <li><a href="#">women</a></li>
                                        <li><a href="#">workout</a></li>
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