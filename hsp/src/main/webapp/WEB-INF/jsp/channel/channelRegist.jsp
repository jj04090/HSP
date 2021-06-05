<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/bizheader.jsp"%>

	<div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
            <div class="custom-container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li class="active"> 채널 등록 </li>
                    </ul>
                </div>
            </div>
        </div>
        
    <div class="login-register-area pt-75 pb-75">
		<div class="container">

	<form name='regit' action="/channel" method="post" enctype="multipart/form-data">
		<div>
			채널 ID : <input type="text" name="channel_id" value=${channel_id} id="channel_id" readonly />
		</div>

		<div>
			유저 ID : <input type="text" name="user_id" value=${user_id} id="user_id" readonly />
		</div>

		<div>
			채널 이름 : <input type="text" name="channel_name" placeholder="채널 이름"id="channel_name" />
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
			채널 카테고리 : <select name="category" id="category">
							<option value="A">모든</option>
							<option value="K">한식</option>
							<option value="C">중식</option>
							<option value="S">양식</option>
						  </select>
		</div>

		<textarea rows="5" cols="50" id="channelDes" name="introduction"></textarea>

		<script>
			var ckeditor_config = {
				resize_enaleb : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				filebrowserUploadUrl : "/channel/ckUpload"
			};

			CKEDITOR.replace("channelDes", ckeditor_config);
		</script>
		
		<div>
			<button type="submit">글 작성</button>
		</div>
	</form>
	
		</div>
	</div>

<%@ include file="../include/bizfooter.jsp"%>
</body>
</html>