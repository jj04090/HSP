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
                    <li class="active">Comment</li>
                </ul>
            </div>
        </div>
    </div>
	
	<form name="edit" action="/community/comme" method="post" enctype="multipart/form-data">
		<input type="hidden" name="_method" value="PUT" />
		
		<div>
			댓글 ID : <input type="text" name="comment_id" value=${comment.comment_id} id="comment_id" readonly />
		</div>
		
		<div>
			유저 ID : <input type="text" name="user_id" value=${comment.user_id} id="user_id" readonly />
		</div>

		<div>
			게시글 ID : <input type="text" name="community_id" value=${comment.community_id} id="community_id" readonly />
		</div>
		
		<div>
			댓글 내용 : <input type="text" name="comment_content" value=${comment.comment_content} id="comment_content" />
		</div>

		<div>
			<button type="submit">댓글 수정</button>
		</div>
	</form>

<%@ include file="../include/footer.jsp"%>
</body>
</html>