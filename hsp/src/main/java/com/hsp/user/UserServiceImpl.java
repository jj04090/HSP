package com.hsp.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsp.certification.CertificationServiceImpl;
import com.hsp.channel.Channel;
import com.hsp.channel.ChannelServiceImpl;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ChannelServiceImpl channelServiceImpl;
	
	@Autowired
	private CertificationServiceImpl certificationServiceImpl;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean login(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			if(getUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", user);
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
			if(certificationServiceImpl.certEmail(user.getEmail())) {
				try {
					userMapper.insert(user);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
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
	public User findID(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			if(certificationServiceImpl.certEmail(user.getEmail())) {
				return getUser;
			}
		}
		return null;
	}

	@Override
	public boolean findPW(User user) {
		User getUser = viewUser(user);
		
		if(getUser != null) {
			if(certificationServiceImpl.certEmail(user.getEmail())) {
				return true;
			}
		}
		return false;
	}

}