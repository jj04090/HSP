package com.hsp.payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.orders.Orders;
import com.hsp.product.Product;
import com.hsp.product.ProductMapper;
import com.hsp.shoppingcart.ShoppingCart;
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
	
	@Autowired
	private ProductMapper productMapper;
	
	//결제 취소
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

	//정기 결제
	@Override
	public boolean routinePayment(Orders orders, int price) throws Exception {
		User user = (User) httpSession.getAttribute("user");
		BigDecimal amount = new BigDecimal(100);
		
		AgainPaymentData againPaymentData = new AgainPaymentData("cid_113", "biling"+new Date().getTime(), amount);
		againPaymentData.setName("빌링키 결제테스트상품입니다.");
		
		IamportResponse<Payment> iamportResponse = new IamportClient("1722439638143134","tV7DKdiRXz5pX53kU9Ohg7Lb17DIiSUMN2pxfIpdhuCezFzuPnL5vwgwEUfXMaJzc97sRwF91ioBXX5N")
				.againPayment(againPaymentData);
		System.out.println(iamportResponse.getMessage()+iamportResponse.getCode()+iamportResponse.getResponse());
		return false;
	}

	//결제 정산
	@Override
	public boolean calculate() throws Exception {
		return false;
	}
	

}
