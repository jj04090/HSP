package com.hsp.orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.channel.Subscribe;
import com.hsp.channel.SubscribeMapper;
import com.hsp.payment.PaymentServiceImpl;
import com.hsp.product.Product;
import com.hsp.product.ProductMapper;
import com.hsp.shoppingcart.ShoppingCart;
import com.hsp.shoppingcart.ShoppingCartMapper;
import com.hsp.user.UserMapper;

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
	@Autowired
	UserMapper userMapper;
	@Autowired
	ReturnsMapper returnsMapper;
	@Autowired
	SubscribeMapper subscribeMapper;
	@Autowired
	ShoppingCartMapper shoppingCartMapper;
	@Autowired
	PaymentServiceImpl paymentServiceImpl;
	
	@Override
	public void applyOrder(Orders orders, Product product) {
		
	}

	@Override
	public String cancelOrder(String order_id) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrder_id(order_id);
		List<OrderDetail> orderDetailList = null;
		Boolean flag = false;
		String result = null;
		try {
			orderDetailList = orderDetailMapper.list(orderDetail);
			for (int i = 0; i < orderDetailList.size(); i++) {
				if (!orderDetailList.get(i).getDelevery_status().equals("O")) {
					result ="판매자가 상품을 발송한 상품이 있어서 취소가 불가능합니다.";
				} else {
					flag = paymentServiceImpl.cancelPayment(order_id);
					if (flag) {
						result = "정상 취소 되었습니다.";
						
						Orders order = new Orders();
						order = ordersMapper.select(order);
						order.setOrder_status("C");
						
						ordersMapper.update(order);						
					} else {
						result = "주문 취소 중 오류가 발생했습니다. 다시 시도 해주세요.";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
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
	public List<String> getStatus(List<Orders> orders) {
		List<String> result = new ArrayList<String>();
		try {
			for (int i = 0; i < orders.size(); i++) {
				result.add("Y");
				List<String> temp = new ArrayList<String>();
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder_id(orders.get(i).getOrder_id());
				List<OrderDetail> orderDetailList = orderDetailMapper.list(orderDetail);
				
				for (int j = 0; j < orderDetailList.size(); j++) {
					if (!orderDetailList.get(j).getDelevery_status().equals("O")) {
						result.set(i, "N");
						break;
					}
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
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
	public void applyReturn(Returns returns) {
		try {
			String return_id = "R" + UUID.randomUUID().toString().subSequence(0, 9);
			returns.setReturn_id(return_id);
			returnsMapper.insert(returns);
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder_id(returns.getOrder_id());
			orderDetail.setProduct_id(returns.getProduct_id());
			orderDetail.setDelevery_status("R");
			orderDetailMapper.statusUpdate(orderDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeStatus(String order_id, String product_id, String delevery_status) {
		OrderDetail result = null;
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrder_id(order_id);
		orderDetail.setProduct_id(product_id);
		
		try {
			result = orderDetailMapper.select(orderDetail);
			result.setDelevery_status(delevery_status);
			orderDetailMapper.statusUpdate(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderInfo viewSold(String order_id, String product_id) {
		Orders order = new Orders();
		order.setOrder_id(order_id);
		OrderInfo orderInfo = null;
		try {
			order = ordersMapper.select(order);
			Map<String, String> query = new HashMap<String, String>();
			query.put("order_id", order_id);
			query.put("product_id", product_id);
			query.put("user_id", order.getUser_id());
			orderInfo = orderInfoMapper.selectForBizView(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderInfo;
	}

	@Override
	public List<Returns> viewReturnList(String channel_id) {
		Product product = new Product();
		product.setChannel_id(channel_id);
		List<Product> productList = null;
		List<Returns> returnsList = new ArrayList<Returns>();
		try {
			productList = productMapper.list(product);
			for (int i = 0; i < productList.size(); i++) {
				Returns returns = new Returns();
				returns.setProduct_id(productList.get(i).getProduct_id());
				returnsList.addAll(returnsMapper.list(returns));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnsList;
	}

	@Override
	public Returns viewReturn(String return_id) {
		Returns returns = new Returns();
		returns.setReturn_id(return_id);
		Returns returnView = null;
		try {
			returnView = returnsMapper.select(returns);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnView;
	}

	@Override
	public int totalPrice(String user_id) {
		double totalPrice = 0;
		
		try {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser_id(user_id);
			List<ShoppingCart> cartList = shoppingCartMapper.list(shoppingCart);
			List<Product> productList = new ArrayList<Product>();
			Map<Product, Integer> productPlusQty = new HashMap<Product, Integer>();
			
			for (ShoppingCart cart : cartList) { // 쇼핑카트에 담긴 상품들 리스트(List<Product>) 생성
				Product product = new Product();
				product.setProduct_id(cart.getProduct_id());
				product = productMapper.select(product);
				
				productPlusQty.put(product, Integer.parseInt(cart.getProduct_count()));
			}
			
			for (Map.Entry<Product, Integer> productQty : productPlusQty.entrySet()) {
				Subscribe subscribe = new Subscribe();
				subscribe.setChannel_id(productQty.getKey().getChannel_id());
				subscribe.setUser_id(user_id);
//				subscribe = subscribeMapper.select(subscribe);
				
				int price = Integer.parseInt(productQty.getKey().getProduct_price());
				int count = 1;
				float discount = 0;
				
				if (subscribe.getChannel_id().isEmpty()) { // 사용자가 구독하지 않는 상태
					count = productQty.getValue();
					
				} else { // 사용자가 구독한 상태
					count = productQty.getValue();
					discount = Float.parseFloat(productQty.getKey().getDiscount());
				}
				
				double discountPrice = price * ( discount / 100 );
				double total = price - discountPrice;
				total = total * count;
				totalPrice = totalPrice + total;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (int)totalPrice;
	}
	
	

	/*
	@Override
	@Scheduled(cron = " 0/10 * * * * *")
	public void schedualTest() {
		System.out.println("현재 시각 : " + new Date(System.currentTimeMillis()));
	}
	*/

}