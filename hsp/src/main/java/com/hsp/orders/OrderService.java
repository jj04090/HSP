package com.hsp.orders;

import java.util.List;

import com.hsp.product.Product;

public interface OrderService {
	public void applyOrder(Orders orders, Product product);
	public String cancelOrder(String order_id); // 파라미터 Orders -> String, 반환타입 void -> String
	public List<Orders> viewOrderList(String user_id);
	
	public List<Returns> viewReturnList(String channel_id);
	public Returns viewReturn(String return_id);
	
	public List<OrderDetail> viewSoldList(String channel_id); //new
	public OrderInfo viewSold(String order_id, String product_id); //new
	public List<String> getStatus(List<Orders> orders);
	
	public List<OrderInfo> viewOrder(String user_id, String order_id); 
	// 파라미터 String user_id 추가, 반환타입 List<OrderInfo>로 변동
	// 파라미터 (String, String)으로 변동
	
	public void applyReturn(Returns returns);
	
//	public void registDelivery(OrderDetail orderDetail);
//	public void confirmDelivery(OrderDetail orderDetail);
//	public void confirmReturn(Returns returns, String status);
	public void changeStatus(String order_id, String product_id, String delevery_status); // 위에꺼 하나로 통합
	
	//public void schedualTest(); // 스케줄러 테스트 메소드
	
	public int totalPrice(String user_id);
}
