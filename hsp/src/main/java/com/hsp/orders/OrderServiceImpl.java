package com.hsp.orders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	ShoppingCartMapper ShoppingCartMapper;
	@Autowired
	ShoppingCartMapper shoppingCartMapper;
	@Autowired
	PaymentServiceImpl paymentServiceImpl;
	
	@Override
	public void applyOrder(Orders orders, String cartType) {
		try {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser_id(orders.getUser_id());
			shoppingCart.setCart_type(cartType);
			List<ShoppingCart> shopingCartList = shoppingCartMapper.list(shoppingCart);
			
			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			orders.setOrder_date(df.format(now));
			orders.setOrder_type(cartType);
			orders.setOrder_status("O");
			ordersMapper.insert(orders);
						
			Subscribe subscribe = new Subscribe();
			subscribe.setUser_id(orders.getUser_id());
//			List<Subscribe> subscribeList = subscribeMapper.list(subscribe); // Subscribe 매퍼 추가 후 사용
			List<Subscribe> subscribeList = new ArrayList<Subscribe>();
			
			for (ShoppingCart shoppingCarts : shopingCartList) {
				Product product = new Product();
				product.setProduct_id(shoppingCarts.getProduct_id());
				product = productMapper.select(product);
				
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder_id(orders.getOrder_id());
				orderDetail.setProduct_id(shoppingCarts.getProduct_id());
				orderDetail.setProduct_qty(shoppingCarts.getProduct_count());
				orderDetail.setPrice(product.getProduct_price());
				
				float discount = 0;
				for (Subscribe subscribes : subscribeList) {
					if (product.getChannel_id().equals(subscribes.getChannel_id())) {
						orderDetail.setDiscount(product.getDiscount());
						discount = Float.parseFloat(product.getDiscount());
					} else {
						orderDetail.setDiscount("0");
					}
				}
				
				orderDetail.setDelevery_status("O");
				
				int price = Integer.parseInt(product.getProduct_price());
				int count = Integer.parseInt(shoppingCarts.getProduct_count());
				double discountPrice = price * ( discount / 100 );
				double total = price - discountPrice;
				total = total * count;
				
				orderDetail.setTotal_price(String.valueOf(total));
				
				orderDetailMapper.insert(orderDetail);
			}
			
			ShoppingCart clearCart = new ShoppingCart();
			clearCart.setUser_id(orders.getUser_id());
			clearCart.setCart_type(cartType);
			shoppingCartMapper.delete(shoppingCart);
			paymentServiceImpl.routinePayment(orders, this.schedualPrice(orders));
			System.out.println("ㅇㅎㅇㅎㅇㅎㅇㅎㅎㅇㅎㅇㅎㅎ"+orders+"======="+this.schedualPrice(orders));//이거 200이넹?
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public List<Orders> viewSoldList(String channel_id) {
		List<Orders> orderList = null;
		
		try {
			orderList = ordersMapper.selectByChannelId(channel_id);
			
			for (int i = 0; i < orderList.size(); i++) {
				Orders orders = ordersMapper.select(orderList.get(i));
				orderList.set(i, orders);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
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
	public List<OrderInfo> viewSold(String order_id, String channel_id) {
		Orders order = new Orders();
		order.setOrder_id(order_id);
		List<OrderInfo> orderInfo = null;
		
		try {
			order = ordersMapper.select(order);
			Map<String, String> query = new HashMap<String, String>();
			query.put("user_id", order.getUser_id());
			query.put("order_id", order_id);
			query.put("channel_id", channel_id);
			
			orderInfo = orderInfoMapper.selectForBizView(query);
			
		} catch (Exception e) {
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
	public int totalPrice(String user_id, String cartType) {
		double totalPrice = 0;
		
		try {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser_id(user_id);
			shoppingCart.setCart_type(cartType);
			List<ShoppingCart> cartList = shoppingCartMapper.list(shoppingCart);
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
				subscribe = subscribeMapper.select(subscribe);
				
				int price = Integer.parseInt(productQty.getKey().getProduct_price());
				int count = 1;
				float discount = 0;
				
				if (subscribe == null) { // 사용자가 구독하지 않는 상태
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

	@Override
	@Scheduled(cron = "0 * 09 * * *") // 10초마다 0/10 * * * * *    // 0 * 09 * * * -> 월요일 9시
	public void schedualOrder() {
		
		try {
			List<Orders> orderList = ordersMapper.list(new Orders());
			
			for (Orders order : orderList) {
				if (order.getOrder_status().equals("W") && order.getOrder_status().equals("O")) {
					String orderDate = order.getOrder_date();
					SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
					Date date = fm.parse(orderDate);
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					
					
					Calendar rightNow = Calendar.getInstance();
//					rightNow.add(Calendar.DATE, -7);
					rightNow.add(Calendar.DATE, -0);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					
					if ( df.format(cal.getTime()).compareTo(df.format(rightNow.getTime())) == 0 ) {
						paymentServiceImpl.routinePayment(order, this.schedualPrice(order));
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int schedualPrice(Orders orders) {
		String user_id = ""; // user_id를 어디에서 가져온다는 가정
		OrderDetail setOrderDetail = new OrderDetail();
		setOrderDetail.setOrder_id(orders.getOrder_id());
		int totalPrice = 0;
		
		try {
			List<OrderDetail> orderDetails = orderDetailMapper.list(setOrderDetail);
			
			for (OrderDetail orderDetail : orderDetails) {
				Product product = new Product();
				product.setProduct_id(orderDetail.getProduct_id());
				product = productMapper.select(product);
				
				int price = Integer.parseInt(product.getProduct_price());
				int count = Integer.parseInt(orderDetail.getProduct_qty());
				float discount = 0;
				
				Subscribe subscribe = new Subscribe();
				subscribe.setUser_id(user_id);
				List<Subscribe> subscribeList = subscribeMapper.list(subscribe); // 매퍼 통해서 가져온다
//				List<Subscribe> subscribeList = new ArrayList<Subscribe>();
				
				for (Subscribe subscribes : subscribeList) {
					if (subscribes.getChannel_id().equals(product.getChannel_id())) {
						discount = Float.parseFloat(product.getDiscount());
					}
				}
				
				double discountPrice = price * ( discount / 100 );
				double total = price - discountPrice;
				total = total * count;
				
				totalPrice = totalPrice + (int)total;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return totalPrice;
	}

	@Override
	public void schedualOrderApply(Orders orders, Orders previousOrder) { // 결제하고 Orders 줘야됨
		
		try {
			orders.setUser_id(previousOrder.getUser_id());
			orders.setOrder_type(previousOrder.getOrder_type());
			
			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			orders.setOrder_date(df.format(now));
			orders.setOrder_type("O");
			ordersMapper.insert(orders);
			
			OrderDetail setOrderDetail = new OrderDetail();
			setOrderDetail.setOrder_id(previousOrder.getOrder_id());
			List<OrderDetail> orderDetailList = orderDetailMapper.list(setOrderDetail);
			
			for (OrderDetail orderDetail : orderDetailList) {
				Product product = new Product();
				product.setProduct_id(orderDetail.getProduct_id());
				product = productMapper.select(product);
				
				int price = Integer.parseInt(product.getProduct_price());
				int count = Integer.parseInt(orderDetail.getProduct_qty());
				float discount = 0;
				
				Subscribe subscribe = new Subscribe();
				subscribe.setUser_id(previousOrder.getUser_id());
//				List<Subscribe> subscribeList = subscribeMapper.list(subscribe); // 매퍼 통해서 가져온다
				List<Subscribe> subscribeList = new ArrayList<Subscribe>();
				
				for (Subscribe subscribes : subscribeList) {
					if (subscribes.getChannel_id().equals(product.getChannel_id())) {
						discount = Float.parseFloat(product.getDiscount());
					}
				}
				
				double discountPrice = price * ( discount / 100 );
				double total = price - discountPrice;
				total = total * count;
				
				orderDetail.setDiscount(String.valueOf(discount));
				orderDetail.setDelevery_status("O");
				orderDetail.setTotal_price(String.valueOf(total));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelSchedual(String order_id) {
		Orders orders = new Orders();
		orders.setOrder_id(order_id);
		orders.setOrder_status("B");
		
		try {
			ordersMapper.update(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}