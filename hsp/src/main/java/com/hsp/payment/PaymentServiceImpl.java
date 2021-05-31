package com.hsp.payment;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.orders.Orders;
import com.hsp.product.Product;
import com.hsp.user.User;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.request.AgainPaymentData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

/*import com.siot.IamportRestHttpClientJava.IamportClient;
import com.siot.IamportRestHttpClientJava.request.CancelData;
import com.siot.IamportRestHttpClientJava.response.IamportResponse;*/

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public boolean cancelPayment(String merchant_uid) throws Exception {
		IamportResponse<Payment> iamportResponse = new IamportClient("1722439638143134","tV7DKdiRXz5pX53kU9Ohg7Lb17DIiSUMN2pxfIpdhuCezFzuPnL5vwgwEUfXMaJzc97sRwF91ioBXX5N")
							.cancelPaymentByImpUid(new CancelData(merchant_uid, false));
		//성공 시
		if(iamportResponse.getCode() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean routinePayment(Orders orders, int price) throws Exception {
		User user = (User) httpSession.getAttribute("user");
		BigDecimal amount = new BigDecimal(100);
		IamportResponse<Payment> iamportResponse = new IamportClient("1722439638143134","tV7DKdiRXz5pX53kU9Ohg7Lb17DIiSUMN2pxfIpdhuCezFzuPnL5vwgwEUfXMaJzc97sRwF91ioBXX5N")
				.againPayment(new AgainPaymentData("cid111", "adfkkdkk", amount));
		System.out.println(iamportResponse.getMessage()+iamportResponse.getCode()+iamportResponse.getResponse());
		return false;
	}
	

}
