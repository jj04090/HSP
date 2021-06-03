package com.hsp.certification;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hsp.channel.Channel;

@RestController
@RequestMapping("/certification")
public class CertificationController {
	@Autowired
	private CertificationServiceImpl certificationServiceImpl;
	
	@GetMapping
	public ModelAndView getToken(String code, String access_token, String refresh_token, String user_seq_no) {
		ModelAndView mv = new ModelAndView();
		
		Channel channel = new Channel();
		
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("code", code);
		parameters.add("client_id", "728a9fc1-5d1d-4db9-b7e9-e9efcadf2f12");
		parameters.add("client_secret", "156bac5f-9552-42f1-8a21-276806f5395c");
		parameters.add("redirect_uri", "http://localhost/certification");
		parameters.add("grant_type", "authorization_code");
		          
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity formEntity = new HttpEntity<>(parameters, headers);

		ResponseEntity<Channel> responseEntity = restTemplate
		    .postForEntity("https://testapi.openbanking.or.kr/oauth/2.0/token", formEntity, Channel.class);
		channel = responseEntity.getBody();
		channel.setUser_id("U02");
		channel.setUser_seq_no(responseEntity.getBody().getUser_seq_no());
		
		if (code != null) {
			certificationServiceImpl.certAccount(channel);
			mv.setViewName("/certification/success");
			mv.addObject("authCode", code);
		} else {
			mv.setViewName("/certification/fail");
		}
		
		return mv;
	}
}
