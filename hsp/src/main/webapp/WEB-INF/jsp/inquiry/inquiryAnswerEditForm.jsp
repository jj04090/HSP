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
                    <li class="active">Inquiry</li>
                </ul>
            </div>
        </div>
    </div>
	
	<!-- 	
	<form name="edit" action="/hsp/inquiry" method="post" enctype="multipart/form-data">
		<input type="hidden" name="_method" value="PUT" />
		 -->
	<form name="edit" action="/inquiryanswerupdate" method="post" enctype="multipart/form-data">
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
			답변 내용 : <input type="text" name="answer" placeholder=${inquiry.answer} id="answer" />
		</div>

		<textarea rows="5" cols="50" id="inquiryDes" name="inquiry_detail">${inquiry.inquiry_detail}</textarea>
		
		<div>
			<button type="submit">문의 수정</button>
		</div>
	</form>

<%@ include file="../include/footer.jsp"%>
</body>
</html>