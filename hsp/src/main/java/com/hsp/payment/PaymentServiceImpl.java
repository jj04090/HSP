package com.hsp.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hsp.channel.Channel;
import com.hsp.channel.ChannelMapper;
import com.hsp.orders.OrderDetail;
import com.hsp.orders.OrderDetailMapper;
import com.hsp.orders.Orders;
import com.hsp.orders.OrdersMapper;
import com.hsp.product.ProductMapper;
import com.hsp.user.User;
import com.hsp.user.UserMapper;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.AgainPaymentData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.BillingCustomer;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
	private OrderDetailMapper orderkDetailMapper;

	@Autowired
	private ChannelMapper channelMapper;

	@Autowired
	private UserMapper userMapper;

	// 결제 취소
	@Override
	public boolean cancelPayment(String merchant_uid) throws Exception {
		IamportResponse<Payment> iamportResponse = new IamportClient("1722439638143134",
				"tV7DKdiRXz5pX53kU9Ohg7Lb17DIiSUMN2pxfIpdhuCezFzuPnL5vwgwEUfXMaJzc97sRwF91ioBXX5N")
						.cancelPaymentByImpUid(new CancelData(merchant_uid, false));
		// 성공 시
		if (iamportResponse.getCode() == 0) {
			return true;
		}
		return false;
	}

	// 정기 결제
	@Override
	public Orders routinePayment(Orders orders, int price) throws Exception {
		User user = (User) httpSession.getAttribute("user");
		BigDecimal amount = new BigDecimal(price);
		String merchantUid = "biling" + new Date().getTime();
		AgainPaymentData againPaymentData = new AgainPaymentData(user.getUser_id()+"bilingkey", merchantUid, amount);
		againPaymentData.setName("빌링키 결제테스트상품입니다.");

		IamportResponse<Payment> iamportResponse = new IamportClient("1722439638143134",
				"tV7DKdiRXz5pX53kU9Ohg7Lb17DIiSUMN2pxfIpdhuCezFzuPnL5vwgwEUfXMaJzc97sRwF91ioBXX5N")
						.againPayment(againPaymentData);
		System.out.println("-==-=-=-=-==-=-"+iamportResponse.getMessage() + iamportResponse.getCode() + iamportResponse.getResponse());
		Orders order = new Orders();
		order.setOrder_id(merchantUid);
		System.out.println(order + "가격 ////////" + price);
		return order;
	}
	
	// 결제 정산
	@Override
	public void calculate() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		

		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");

		 // order 테이블의 주문상태가 결제완료인 것들을 확인하여 order_detail의 주문상태가 전부 O인 경우가 아니면 정산 진행

		List<Orders> list = ordersMapper.list(new Orders());

		for (Orders orders : list) {
			String temp = orders.getOrder_status();
			// 결제가 취소 되거나 정산이 된 상태가 아니라면
			if (temp != "C" || temp != "P") {
				Map<OrderDetail, Channel> map = calCheck(orders);
				for (OrderDetail key : map.keySet()) {
					
					JSONObject jsonObject = new JSONObject();
					JSONArray jsonArray = new JSONArray();
					JSONObject finalJsonObject = new JSONObject();
					
					Channel channel = map.get(key);
					User user = new User();
					user.setUser_id(channel.getUser_id());
					user = userMapper.select(user);
					
					String code = "M202111883U1" + UUID.randomUUID().toString().substring(0, 8);
					
					jsonObject.put("tran_no", "1");
					jsonObject.put("bank_tran_id", code.toUpperCase());
					jsonObject.put("bank_code_std", "004");
					jsonObject.put("account_num", "94290200018493");
					jsonObject.put("account_holder_name", "유상진");
					jsonObject.put("print_content", "정산");
					jsonObject.put("tran_amt", "100");
					jsonObject.put("req_client_name", "유상진");
					jsonObject.put("req_client_bank_code", "004");
					jsonObject.put("req_client_account_num", "94290200018493");
					jsonObject.put("req_client_num", "HONGGILDONG1234");
					jsonObject.put("transfer_purpose", "AU");

					jsonArray.add(jsonObject);

					finalJsonObject.put("cntr_account_type", "N");
					finalJsonObject.put("cntr_account_num", "1002753751174");
					finalJsonObject.put("wd_pass_phrase", "NONE");
					finalJsonObject.put("wd_print_content", "환불금액");
					finalJsonObject.put("name_check_option", "off");
					finalJsonObject.put("tran_dtime", date.format(new Date()));
					finalJsonObject.put("req_cnt", "1");
					finalJsonObject.put("req_list", jsonArray);

					HttpHeaders headers = new HttpHeaders();
					headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
					headers.add("Authorization",
							"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMTExODgzIiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjMwNDA2MzkyLCJqdGkiOiI0MzU2ODY4Ny03MTJhLTQzMGYtYTE0YS00NmZiMmU0MTBiODEifQ.KY3tE5__XGrfXU8-h5ZN0cYbJMuecXpmQa4np036p_Y");
					HttpEntity formEntity = new HttpEntity<>(finalJsonObject, headers);

					ResponseEntity<String> responseEntity = restTemplate.postForEntity(
							"https://testapi.openbanking.or.kr/v2.0/transfer/deposit/acnt_num", formEntity, String.class);
					System.out.println(responseEntity.getBody());
					
					orders.setOrder_status("P");
					ordersMapper.update(orders);
				}	
			}
		}
	} 

	public Map<OrderDetail, Channel> calCheck(Orders orders) throws Exception {
		// 주문한 상품들의 채널을 가져옴
		Map<OrderDetail, Channel> map = new HashMap<>();
		List<OrderDetail> detailList;

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrder_id(orders.getOrder_id());
		detailList = orderkDetailMapper.list(orderDetail);

		boolean flag = false;

		for (OrderDetail od : detailList) {
			map.put(od, channelMapper.selectByProductId(od.getProduct_id()));
			if (od.getDelevery_status() != "O") {
				flag = true;
			}
		}
		// 정산 허용
		if (flag) {
			return map;
		}
		return null;
	}
	
	public boolean checkBilingKey(String user_id) {
		try {
			IamportResponse<BillingCustomer> response = new IamportClient("1722439638143134",
					"tV7DKdiRXz5pX53kU9Ohg7Lb17DIiSUMN2pxfIpdhuCezFzuPnL5vwgwEUfXMaJzc97sRwF91ioBXX5N").getBillingCustomer(user_id+"bilingkey");
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}