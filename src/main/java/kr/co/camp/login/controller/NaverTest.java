package kr.co.camp.login.controller;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.camp.service.LoginService;
//https://java.net/projects/javamail/pages/Home

@Controller
public class NaverTest {
	
	@Autowired
	private LoginService service;
	
    public void sendEmail(String recipient) throws Exception{
        String host = "smtp.naver.com";
        final String username = "rlagusdud159";
        final String password = "";
        int port = 465;

        String subject = "캠프파이어 사이트에서 알려드립니다. [아이디 찾기 서비스]";
         
        System.out.println(service);
        String body = "아이디 : " +  service.searchId(recipient);
        System.out.println("아이디 : " + service.searchId(recipient));
        Properties props = System.getProperties();
         
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
          
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            String un = username;
            String pw = password;
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(un, pw);
            }
        });
        session.setDebug(true);

        Message mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("rlagusdud159@naver.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(body);
        Transport.send(mimeMessage);
        System.out.println("성공");
    }
}