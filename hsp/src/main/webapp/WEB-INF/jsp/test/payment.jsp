<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<button id="payment" type="button">등록</button>

	<form id="blogForm" action="/shoppingcart" method="POST">
		<input type="hidden" name="_method" value="PUT" />
		<button type="submit">미션등록</button>
	</form>

	<button id="cancel" type="button">취소</button>


</body>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	document.getElementById('payment').addEventListener('click', ajax_call);

	function ajax_call() {
		var IMP = window.IMP;
		var iamportRequest;
		IMP.init('imp99346121'); //이거 받아와서 숨기기
		$.ajax({
			type : 'POST',
			url : '/payment/routine', //구별하기
			data : {
				user : {
					user_id : "aa"
				},
				product : {
					product_id : null
				}
			},
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
						location.replace('/shoppingcart');
						/* $.ajax({      //주문등록으로 보내기, 주문이랑(orders_id) 상품PK를 보냄
						    type: 'POST',
						    url: '/payment',
						    headers: { "Content-Type": "application/json" },
						    data: {
						    	merchant_uid: rsp.merchant_uid
						    }
						}); */
					} else {
						var msg = '결제에 실패하였습니다.';
						var iconValue = 'error';
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

	document.getElementById('cancel').addEventListener('click', cancel_call);
	function cancel_call() {
		$.ajax({
			type : 'POST',
			url : '/shoppingcart',
			data : {
				order_id : "merchant_33"
			}
		});
	}
</script>
</html>