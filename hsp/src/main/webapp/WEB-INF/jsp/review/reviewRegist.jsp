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
                    <li class="active">Review</li>
                </ul>
            </div>
        </div>
    </div>

	<form name='regit' action="/hsp/review" method="post" enctype="multipart/form-data">
		<div>
			리뷰 ID : <input type="text" name="review_id" value=${review_id} id="review_id" readonly />
		</div>

		<div>
			주문 ID : <input type="text" name="order_id" value=${order_id} id="order_id" readonly />
		</div>
		
		<div>
			상품 ID : <input type="text" name="product_id" value=${product_id} id="product_id" readonly />
		</div>

		<div>
			리뷰 제목 : <input type="text" name="review_title" placeholder="제목" id="review_title" />
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
			리뷰 내용 : <input type="text" name="review_content" placeholder="내용" id="review_content" />
		</div>

		<textarea rows="5" cols="50" id="reviewDes" name="review_detail"></textarea>

		<script>
			var ckeditor_config = {
				resize_enaleb : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				filebrowserUploadUrl : "/hsp/review/ckUpload"
			};

			CKEDITOR.replace("reviewDes", ckeditor_config);
		</script>
		
		<div>
			<button type="submit">리뷰 작성</button>
		</div>
	</form>

<%@ include file="../include/footer.jsp"%>
</body>
</html>