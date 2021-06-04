package com.hsp.user;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.certification.EmailServiceImpl;
import com.hsp.channel.Channel;
import com.hsp.channel.ChannelServiceImpl;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ChannelServiceImpl channelServiceImpl;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean login(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			if(getUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", getUser);
				session.setMaxInactiveInterval(60 * 60);
			}
			return true;
		}
		return false;
	}

	@Override
	public void logout() {
		if(session != null) {
			session.invalidate();
		}	
	}

	@Override
	public void registUser(User user) {
		User checkUser = new User();
		checkUser.setUser_id(user.getUser_id());
		
		User getUser = viewUser(checkUser);
		if(getUser == null) {
			try {
				userMapper.insert(user);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUser(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			Channel channel = new Channel();
			channel.setUser_id(user.getUser_id());
			
			Channel getChannel = channelServiceImpl.viewChannel(channel);
			if(getChannel == null) {
				try {
					userMapper.delete(user);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			userMapper.update(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User viewUser(User user) {
		try {
			return userMapper.select(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void findID(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			emailServiceImpl.sendID(getUser);
		}
	}

	@Override
	public void findPW(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			emailServiceImpl.sendPW(getUser);
		}
	}

	@Override
	public String encryptPW(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}