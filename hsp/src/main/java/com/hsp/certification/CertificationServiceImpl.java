package com.hsp.certification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.channel.Channel;
import com.hsp.channel.ChannelMapper;

@Service
public class CertificationServiceImpl implements CertificationService {
	@Autowired
	private ChannelMapper channerMapper;

	@Override
	public boolean certEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void certAccount(Channel channel) {
		try {
			channerMapper.update(channel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
