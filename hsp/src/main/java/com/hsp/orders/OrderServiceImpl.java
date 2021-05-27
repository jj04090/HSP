package com.hsp.orders;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public void applyOrder(Orders order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOreder(Orders order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orders> viewOrderList(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> viewOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registDelivery(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmDelivery(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyReturn(Returns returns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmReturn(Returns returns, String status) {
		// TODO Auto-generated method stub
		
	}

}