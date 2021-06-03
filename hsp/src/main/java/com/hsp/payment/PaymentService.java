package com.hsp.payment;

import com.hsp.orders.Orders;

public interface PaymentService {

	//결제 취소
	public boolean cancelPayment(String merchant_uid) throws Exception;
	
	//정기 결제
	public Orders routinePayment(Orders orders, int amount) throws Exception;
	
	//결제 정산
	public void calculate() throws Exception;
}
