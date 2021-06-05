<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
        <div class="breadcrumb-area breadcrumb-area-padding-2 bg-gray-2">
            <div class="custom-container">
                <div class="breadcrumb-content text-center">
                    <ul>
                        <li>
                            <a href="index.html">홈</a>
                        </li>
                        <li class="active">장바구니</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="cart-area pt-75 pb-35">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <form action="#">
                            <div class="cart-table-content">
                                <div class="table-content table-responsive">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th class="width-thumbnail "><b>상 품</b></th>
                                                <th class="width-name"></th>
                                                <th class="width-price"><b>가 격</b></th>
                                                <th class="width-quantity"><b>수 량</b></th>
                                                <th class="width-subtotal"><b>소 계</b></th>
                                                <th class="width-remove"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:set var = "sum" value = "0" />
                                        <c:forEach items="${shoppingList}" var = "cartValue">
                                         <input type="hidden" value="${cartValue.shoppingCart.user_id}" id="userId">
                                            <tr>
                                                <td class="product-thumbnail">
                                                    <a href="product-details.html"><img class='small1' src="/product/display?filename=${cartValue.product.product_img}"></a>
                                                </td>
                                                <td class="product-name">
                                                    <h5><a href="/hsp/product/${cartValue.product.product_id}"> <c:out value="${cartValue.product.product_name}" /> </a></h5>
                                                </td>
                                                <td class="product-price"><span class="amount"><c:out value="${cartValue.product.product_price}" /> ￦</span></td>
                                                <td class="cart-quality">
                                                    <div class="product-quality">
                                                        <input class="cart-plus-minus-box input-text qty text" name="qtybutton" value="${cartValue.shoppingCart.product_count}" id="${cartValue.product.product_id}">
                                                    </div>
                                                </td>
                                                <td class="product-total"><span><c:out value="${cartValue.product.product_price * cartValue.shoppingCart.product_count}" /> ￦</span></td>
                                                <c:set var= "sum" value="${cartValue.product.product_price * cartValue.shoppingCart.product_count + sum}"/>
                                                <td class="product-remove"><a href="#">삭 제</a></td>
                                            </tr>
                                        </c:forEach>
                                        
                                        </tbody>
                                    </table>
                                </div>
                                <div class="cart-shiping-update-wrapper">
                                    <div class="continure-clear-btn">
                                        <div class="clear-btn">
                                            <a href="#" onclick="delete_call();"><i class="fal fa-times"></i>장바구니 비우기</a>
                                        </div>
                                    </div>
                                    <div class="update-btn">
                                        <a href="#" onclick="edit_call();">장바구니 수정</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12 col-12">
                        <div class="coupon-wrap mb-40">
                            <h4><b>※ 주의 사항 ※</b></h4>
                            <p>1. 수량을 변경 후 장바구니 수정을 하셔야 반영됩니다. </p>
                            <p>2. 주소는 회원의 주소로 설정됩니다. </p>
                            <div class="grand-total-wrap mb-40">
                                
                                <div class="input-style coupon-content-mrg">
                                    <i></i>
                                </div>
                                <div class="common-btn-style">
                                    <a class="common-btn-padding-2" href="/user/edit">주소 변경하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-12 col-12">
                        <div class="row">
                        <div class="col-lg-6 col-md-6 col-12">
                                <div class="cart-collaterals-wrap mb-40">
                                    <h4> </h4>
                                    
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-12">
                            <h4><b>총 주문 금액</b></h4>
                             <p>구독자 할인율이 적용된 총 구매금액 입니다. </p>
                                <div class="grand-total-wrap mb-40">
                                
                                    <ul>
                                        <li>합계 <h4><c:out value="${sum}"/> ￦</h4>
                                        </li>
                                        <li>할인 금액 <h4><span>-</span><c:out value="${sum-total}"/> ￦</h4>
                                        </li>
                                    </ul>
                                    <div class="grand-total">
                                        <h4>총 결제금액 <span>${total} ￦</span></h4>
                                    </div>
                                    <div class="grand-total-btn">
                                        <a onclick="payment_call();">결 제</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@ include file="../include/footer.jsp"%>
</body>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	function payment_call() {
		var IMP = window.IMP;
		var iamportRequest;
		IMP.init('imp99346121'); //이거 받아와서 숨기기
		var urlType = "/payment";
		
		<c:if test="${cartType eq 'W'}">
			urlType = "/payment/routine";
		</c:if>
		
		$.ajax({
			type : 'POST',
			url : urlType,
			success : function(data) {
				console.log(data);
				IMP.request_pay({
					pg : data.pg,
					pay_method : data.pay_method,
					merchant_uid : data.merchant_uid,
					name : data.name,
					amount : data.amount,
					buyer_email : data.buyer_email,
					buyer_name : data.buyer_name ,
					customer_uid: data.customer_uid 
				}, function(rsp) {
					if (rsp.success) {
						var msg = '결제가 완료되었습니다.\n';
						msg += '결제 금액 : ' + rsp.paid_amount;
						var iconValue = 'success';
						swal({
							title : "결제 상태",
							text : msg,
							icon : iconValue
						//"info,success,warning,error" 중 택1
						})
						$.ajax({      //주문등록으로 보내기, 주문객체(orders_id) 보냄
						    type: 'POST',
						    url: '/order',
						   // headers: { "Content-Type": "application/json" },
						    data: {
						    	order_id: rsp.merchant_uid,
						    	user_id : document.getElementById("userId").value,
						    	cartType : '${cartType}'
						    }, success:function(data) {
						    	location.href="/order";
						    }
						});
					} else {
						var msg = '결제에 실패하였습니다.';
						var iconValue = 'error';
						console.log(rsp)
					}
					swal({
						title : "결제 상태",
						text : msg,
						icon : iconValue
					//"info,success,warning,error" 중 택1
					})
	
				});//
			}
		})
	
	};
	
	function edit_call() {
		//장바구니 동적으로 json 세팅
		var arr = new Array(); //Object를 배열로 저장할 Array
        var obj; //key, value형태로 저장할 Object


		<c:forEach items="${shoppingList}" var="item">
			obj = new Object();
			obj.user_id = "${item.shoppingCart.user_id}";
			obj.product_id = "${item.product.product_id}";
			obj.product_count = document.getElementById("${item.product.product_id}").value;
			arr.push(obj);
		</c:forEach>
		
		console.log(JSON.stringify(arr));
			
		$.ajax({
			type : 'PUT',
			url : '/shoppingcart',
			contentType: "application/json",
			data : JSON.stringify(arr),
			success: function(data){
				location.reload(true);
			}
		});
	}
	
	function delete_call() {
		console.log(document.getElementById("userId").value);
			
		$.ajax({
			type : 'DELETE',
			url : '/shoppingcart',
			data : {
				user_id : document.getElementById("userId").value
			},
			success: function(data){
				location.reload(true);
			}
		});
	}
</script>
</html>