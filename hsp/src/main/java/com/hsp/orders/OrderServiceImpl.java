package com.hsp.orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.product.ProductMapper;
import com.hsp.user.User;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdersMapper ordersMapper;
	@Autowired
	OrderDetailMapper orderDetailMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	@Override
	public void applyOrder(Orders orders) {
		// TODO Auto-generated method stub
		//product의 값이 없음 -> 장바구니에서 결제한거 select를 한번 해줘야함 -> 주문등록 -> 주문명세
		//product의 값이 있음 -> 단일결제 -> 정기인지 일반인지 구별
		//일반일 경우에는 주문 등록 -> 주문 명세 등록하고 
		//정기일 경우에는 주문등록 하기 전에 결제를 진행 paymentService.routinePayment(Orders orders, int price //최종결젝 계산해서)->
		
	}

	@Override
	public void cancelOreder(Orders orders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orders> viewOrderList(String user_id) {
		Orders orders = new Orders();
		orders.setUser_id(user_id);
		List<Orders> ordersList = null;
		try {
			ordersList = ordersMapper.list(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersList;
	}
	
	@Override
	public List<OrderDetail> viewSoldList(String channel_id) {
		List<OrderDetail> orderInfoList = null;
		try {
			orderInfoList = orderDetailMapper.selectByChannelId(channel_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderInfoList;
	}

	@Override
	public List<OrderInfo> viewOrder(String user_id, String order_id) {
		List<OrderInfo> orderInfoList = null;
		try {
			HashMap<String, String> orderid = new HashMap<String, String>();
			orderid.put("user_id", user_id);
			orderid.put("order_id", order_id);
			orderInfoList = orderInfoMapper.selectByOrder_id(orderid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderInfoList;
	}
	
	@Override
	public List<OrderInfo> viewSoldDetail(String order_id) {
		Orders orders = new Orders();
		orders.setOrder_id(order_id);
		Orders ordersByorder_id = null;
		List<OrderInfo> orderInfoList = null;
		List<OrderInfo> orderInfoFull = new ArrayList<OrderInfo>();
		try {
			ordersByorder_id = ordersMapper.select(orders); // 여기에 주문한 user_id가 담겨있음
			//User에서 쿼리해서 주소 가져와야됨
			User user = null;// 유저매퍼에서 유저ID를 기준으로 -> User를 가져옴
			orderInfoList = orderInfoMapper.selectForBiz(order_id);
			for (int i = 0; i < orderInfoList.size(); i++) {
				OrderInfo orderInfoBlank = orderInfoList.get(i);
				orderInfoBlank.setAddress(user.getAddress());
				orderInfoBlank.setDetail_address(user.getDetail_add());
				orderInfoBlank.setZip_code(user.getZip_code());
				
				orderInfoFull.add(orderInfoBlank);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderInfoFull;
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