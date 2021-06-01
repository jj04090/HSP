package com.hsp.payment;

import java.util.List;

import com.hsp.orders.Orders;
import com.hsp.product.Product;

public interface PaymentService {

	//결제 취소
	public boolean cancelPayment(String merchant_uid) throws Exception;
	
	//정기 결제
	public boolean routinePayment(Orders orders, int amount) throws Exception;
	
	//결제 정산
	public boolean calculate() throws Exception;
}
