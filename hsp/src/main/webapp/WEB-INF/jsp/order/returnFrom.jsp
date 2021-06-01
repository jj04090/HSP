<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return</title>

<script src="/resources/ckeditor/ckeditor.js"></script>

<style>
	.image_container img { margin:20px 0; }
</style>

</head>
<body>
	<h1>반품 신청</h1>

	<form name='regit' action="/order/return" method="post" enctype="multipart/form-data">
		<div>
			주문 ID : <input type="text" name="order_id" value=${order_id} id="order_id" readonly />
		</div>

		<div>
			상품 ID : <input type="text" name="product_id" value=${product_id} id="product_id" readonly />
		</div>
		
		<div>
		반품 사유
		<textarea rows="5" cols="50" id="return_reason" name="return_reason"></textarea>

		<script>
			var ckeditor_config = {
				resize_enaleb : false,
				enterMode : CKEDITOR.ENTER_BR,
				shiftEnterMode : CKEDITOR.ENTER_P,
				filebrowserUploadUrl : "/hsp/product/ckUpload"
			};

			CKEDITOR.replace("return_reason", ckeditor_config);
		</script>
		</div>
		
		<div>
			<button type="submit">글 작성</button>
		</div>
	</form>

</body>
</html>