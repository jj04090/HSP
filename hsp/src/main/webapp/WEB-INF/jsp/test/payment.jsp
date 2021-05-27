<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		
	<button style="font-weight: bold;" id="payment" type="button">
		등록
	</button>

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
					IMP.init('imp99346121'); //이거 xhr로 받아와서 숨기기
					IMP.request_pay({
						pg : 'html5_inicis',
						pay_method : 'card',
						merchant_uid : "a",
						name : "a",
						amount : "1000",
						buyer_email : "a",
						buyer_name : "a"
					}, function(rsp) {
						if (rsp.success) {
							var msg = '결제가 완료되었습니다.\n';
							msg += '결제 금액 : ' + rsp.paid_amount;
							var iconValue = 'success';
						} else {
							var msg = '결제에 실패하였습니다.';
							var iconValue = 'error';
						}
						swal({
							   title: "결제 상태",
							   text: msg,
							   icon: iconValue//"info,success,warning,error" 중 택1
							})
					});
			
	};
</script>
</html>