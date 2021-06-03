<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Community Update</title>

<script src="/resources/ckeditor/ckeditor.js"></script>

<style>
	.image_container img { margin:20px 0; }
	.small1 { width: 500px; }
	.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>채널 수정</h1>
	
	<!-- 	
	<form name="edit" action="/hsp/community" method="post" enctype="multipart/form-data">
		<input type="hidden" name="_method" value="PUT" />
		 -->
	<form name="edit" action="/hsp/communityupdate" method="post" enctype="multipart/form-data">
		<!-- <input type="hidden" name="_method" value="PUT" />  -->
		
		<div>
			채널 ID : <input type="text" name="channel_id" value=${community.channel_id} id="channel_id" readonly />
		</div>

		<div>
			채널 ID : <input type="text" name="community_id" value=${community.product_id} id="product_id" readonly />
		</div>

		<div>
			게시글 제목 : <input type="text" name="community_title" placeholder=${community.community_title} id="community_title" />
		</div>
		
		<div>
			미디어파일 : <img class='small1' src="/hsp/community/display?filename=${community.mediafile}"/>
			<input type="hidden" name="mediafile" value="${community.mediafile}">
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
			게시글 내용 : <input type="text" name="community_content" placeholder=${community.community_content} id="community_content" />
		</div>

		<textarea rows="5" cols="50" id="communityDes" name="community_detail">${community.community_detail}</textarea>

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
			<button type="submit">게시글 수정</button>
		</div>
	</form>

</body>
</html>