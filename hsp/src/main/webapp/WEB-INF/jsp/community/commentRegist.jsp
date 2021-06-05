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

	<form name='regit' action="/community/comme" method="post" enctype="multipart/form-data">
		<div>
			댓글 ID : <input type="text" name="comment_id" value=${comment_id} id="comment_id" readonly />
		</div>
		
		<div>
			댓글 ID : <input type="text" name="user_id" value=${user_id} id="user_id" readonly />
		</div>

		<div>
			커뮤니티 ID : <input type="text" name="community_id" value=${community_id} id="community_id" readonly />
		</div>

		<div>
			등록 날짜 : <input type="text" name="regit_date" value=${regit_date} id="regit_date" readonly />
		</div>

		<div>
			댓글 내용 : <input type="text" name="comment_content" placeholder="내용" id="comment_content" />
		</div>
		
		<div>
			<button type="submit">댓글 작성</button>
		</div>
	</form>

<%@ include file="../include/footer.jsp"%>
</body>
</html>