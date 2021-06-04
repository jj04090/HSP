package com.hsp.certification;

import com.hsp.user.User;

public interface EmailService {
	public void sendID(User user);
	public void sendPW(User user);
}
