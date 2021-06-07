<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/bizheader.jsp"%>

	<div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
            <div class="custom-container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li class="active"> 상품 등록 </li>
                    </ul>
                </div>
            </div>
        </div>
        
    <div class="login-register-area pt-75 pb-75">
		<div class="container">

	<form name='regit' action="/product" method="post" enctype="multipart/form-data">
		<div>
			채널 ID : <input type="text" name="channel_id" value=${channel_id} id="channel_id" />
		</div>

		<div>
			상품 ID : <input type="text" name="product_id" value=${product_id} id="product_id" readonly />
		</div>

		<div>
			상품 제목 : <input type="text" name="product_name" placeholder="제목"id="product_name" />
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
			상품 가격 : <input type="text" name="product_price" placeholder="가격" id="product_price" />
		</div>

		<div>
			제공할 할인율 : <input type="text" name="discount" placeholder="제공할 할인율" id="discount" />
		</div>

		<div>
			주문 가능한 주기 : <select name="orderable_cycle" id="orderable_cycle">
							<option value="S">일반</option>
							<option value="W">정기</option>
						  </select>
		</div>

		<textarea rows="5" cols="50" id="productDes" name="product_detail"></textarea>

		<script>
			var ckeditor_config = {
				resize_enaleb : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				filebrowserUploadUrl : "/product/ckUpload"
			};

			CKEDITOR.replace("productDes", ckeditor_config);
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