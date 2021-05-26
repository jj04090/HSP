<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src = "/resources/ckeditor/ckeditor.js"></script>

</head>
<body>
	Test JSP
	
	<label for="gdsDes">상품소개</label>
	<textarea rows = "5" cols = "50" id = "gdsDes" name = "gdsDes"></textarea>
	
	<script>
 		var ckeditor_config = {
   		resize_enaleb : false,
   		enterMode : CKEDITOR.ENTER_BR,
   		shiftEnterMode : CKEDITOR.ENTER_P,
   		filebrowserUploadUrl : "/admin/goods/ckUpload"
 		};
 
		CKEDITOR.replace("gdsDes", ckeditor_config);
	</script>
	
</body>
</html>