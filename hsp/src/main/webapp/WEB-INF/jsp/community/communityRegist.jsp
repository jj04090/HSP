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

	<form name='regit' action="/hsp/community" method="post" enctype="multipart/form-data">
		<div>
			게시글 ID : <input type="text" name="community_id" value=${community_id} id="community_id" readonly />
		</div>

		<div>
			채널 ID : <input type="text" name="channel_id" value=${channel_id} id="channel_id" readonly />
		</div>

		<div>
			게시글 제목 : <input type="text" name="community_title" placeholder="제목" id="community_title" />
		</div>
		
		<input type="file" name="attach" id="image" accept="image/*" onchange="setThumbnail(event);"/> 
		<div id="image_container"></div> 
		<script> 
		function setThumbnail(event) {
			var reader = new FileReader(); 
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				document.querySelector("div#image_container").appendChild(img); 
			};
				
			reader.readAsDataURL(event.target.files[0]); 
		} 
		</script>
		
		<div>
			게시글 내용 : <input type="text" name="community_content" placeholder="내용" id="community_content" />
		</div>

		<textarea rows="5" cols="50" id="communityDes" name="community_detail"></textarea>

		<script>
			var ckeditor_config = {
				resize_enaleb : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				filebrowserUploadUrl : "/hsp/community/ckUpload"
			};

			CKEDITOR.replace("communityDes", ckeditor_config);
		</script>
		
		<div>
			<button type="submit">게시글 작성</button>
		</div>
	</form>

<%@ include file="../include/footer.jsp"%>
</body>
</html>