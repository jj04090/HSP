<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquiry Update</title>

<style>
	.image_container img { margin:20px 0; }
	.small1 { width: 500px; }
	.small2 { height: 100px; }
</style>

</head>
<body>
	<h1>문의 수정</h1>
	
	<!-- 	
	<form name="edit" action="/hsp/inquiry" method="post" enctype="multipart/form-data">
		<input type="hidden" name="_method" value="PUT" />
		 -->
	<form name="edit" action="/hsp/inquiryupdate" method="post" enctype="multipart/form-data">
		<!-- <input type="hidden" name="_method" value="PUT" />  -->
		
		<div>
			문의 ID : <input type="text" name="inquiry_id" value=${inquiry.inquiry_id} id="inquiry_id" readonly />
		</div>

		<div>
			유저 ID : <input type="text" name="user_id" value=${inquiry.user_id} id="user_id" readonly />
		</div>
		
		<div>
			상품 ID : <input type="text" name="product_id" value=${inquiry.product_id} id="inquiry_id" readonly />
		</div>

		<div>
			문의 제목 : <input type="text" name="inquiry_title" placeholder=${inquiry.inquiry_title} id="inquiry_title" />
		</div>
		
		<div>
			문의 내용 : <input type="text" name="inquiry_content" placeholder=${inquiry.inquiry_content} id="inquiry_content" />
		</div>

		<textarea rows="5" cols="50" id="inquiryDes" name="inquiry_detail">${inquiry.inquiry_detail}</textarea>
		
		<div>
			<button type="submit">문의 수정</button>
		</div>
	</form>

</body>
</html>