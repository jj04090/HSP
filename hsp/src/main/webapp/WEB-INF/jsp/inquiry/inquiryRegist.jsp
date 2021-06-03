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

	<form name='regit' action="/hsp/inquiry" method="post" enctype="multipart/form-data">
		<div>
			문의 ID : <input type="text" name="inquiry_id" value=${inquiry_id} id="inquiry_id" readonly />
		</div>

		<div>
			유저 ID : <input type="text" name="user_id" value=${user_id} id="user_id" readonly />
		</div>
		
		<div>
			상품 ID : <input type="text" name="product_id" value=${product_id} id="product_id" readonly />
		</div>

		<div>
			문의 제목 : <input type="text" name="inquiry_title" placeholder="제목" id="inquiry_title" />
		</div>
		
		<div>
			문의 내용 : <input type="text" name="inquiry_content" placeholder="내용" id="inquiry_content" />
		</div>

		<textarea rows="5" cols="50" id="inquiryDes" name="inquiry_detail"></textarea>
		
		<div>
			<button type="submit">문의 작성</button>
		</div>
	</form>

<%@ include file="../include/footer.jsp"%>
</body>
</html>