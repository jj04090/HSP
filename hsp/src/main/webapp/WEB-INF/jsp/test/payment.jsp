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

	<button id="auth" type="button">본인인증</button>	

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
			url : '/payment', //구별하기
			data : {
				user : {
					user_id : "aa"
				}/* ,
				product : {
					product_id : 1
				} */
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
						//location.replace('/shoppingcart');
						/* $.ajax({      //주문등록으로 보내기, 주문객체(orders_id) 보냄
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
	
	//ajax로 채널생성하고 성공이면 이걸 실행 -> 실패시 인증받으라고 알려주기, 성공 시 성공 표시하고 창 닫기
	$("#auth").click(function(){
        var tmpWindow = window.open('about:blank','_blank','width=500,height=600,top=60,left=500')
        tmpWindow.location = "https://testapi.openbanking.or.kr/oauth/2.0/authorize?"+
			"response_type=code&"+
            "client_id=728a9fc1-5d1d-4db9-b7e9-e9efcadf2f12&"+ // 
            "redirect_uri=http://localhost/certification&"+
            "scope=login inquiry transfer&"+
            "state=12345678901234567890123456789012&"+
            "auth_type=0&"+
            "authorized_cert_yn=N"
    })

</script>
</html>