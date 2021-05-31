package com.hsp.orders;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
	public void applyOrder(Orders orders);
	public void cancelOrder(String order_id); // 파라미터 Orders -> String
	public List<Orders> viewOrderList(String user_id);
	
	public List<OrderDetail> viewSoldList(String channel_id); //new
	
	public List<OrderInfo> viewOrder(String user_id, String order_id); 
	// 파라미터 String user_id 추가, 반환타입 List<OrderInfo>로 변동
	// 파라미터 (String, String)으로 변동
	
	public List<OrderInfo> viewSoldDetail(String order_id); //new
	
	public void registDelivery(OrderDetail orderDetail);
	public void confirmDelivery(OrderDetail orderDetail);
	public void applyReturn(Returns returns);
	public void confirmReturn(Returns returns, String status);
	
	//public void schedualTest(); // 스케줄러 테스트 메소드
}
