package com.hsp.orders;

import java.util.List;

public interface OrderService {
	public void applyOrder(Orders order);
	public void cancelOreder(Orders order);
	public List<Orders> viewOrderList(Orders order);
	public List<OrderDetail> viewOrder(Orders order);
	public void registDelivery(OrderDetail orderDetail);
	public void confirmDelivery(OrderDetail orderDetail);
	public void applyReturn(Returns returns);
	public void confirmReturn(Returns returns, String status);
}
