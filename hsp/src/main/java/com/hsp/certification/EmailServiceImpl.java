package com.hsp.certification;

import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hsp.user.User;
import com.hsp.user.UserServiceImpl;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	public void sendID(User user) {
		String user_id = userServiceImpl.viewUser(user).getUser_id();
		String subject = "아이디 찾기";
		String text = "회원님의 아이디는 (" + user_id + ") 입니다.";
		
		MimeMessage mail = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			mailHelper.setFrom("smcapstoneteam03@gmail.com");
			mailHelper.setTo(user.getEmail());
			mailHelper.setSubject(subject);
			mailHelper.setText(text);
			mailSender.send(mail);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendPW(User user) {
		String tempPW = getRandomCode();
		String subject = "비밀번호 찾기";
		String text = "임시 비밀번호는 (" + tempPW + ") 입니다.";
		
		MimeMessage mail = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
			mailHelper.setFrom("smcapstoneteam03@gmail.com");
			mailHelper.setTo(user.getEmail());
			mailHelper.setSubject(subject);
			mailHelper.setText(text);
			mailSender.send(mail);
			
			String encryptPW = userServiceImpl.encryptPW(tempPW);
			user.setPassword(encryptPW);
			userServiceImpl.updateUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getRandomCode() {
        Random random = new Random();
        String code = "";
        
        for(int i=0; i<10; i++) {
        	int n = (int)48 + (int)(random.nextDouble() * 74);
        	code = code + (char)n;
        }
		return code;
    }

}
