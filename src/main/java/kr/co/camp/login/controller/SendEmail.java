package kr.co.camp.login.controller;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;  
  
public class SendEmail  {  
 public static void main(String [] args) throws Exception{  
	 
      String to = "@naver.com";//change accordingly  
      String from = "@naver.com";
      String host = "smtp.naver.com";//or IP address  
      int port = 465;
     //Get the session object  
      Properties props =  System.getProperties();
      props.put("mail.smtp.host", host); 
      props.put("mail.smtp.port", port); 
      props.put("mail.smtp.auth", "true");  
      props.put("mail.smtp.ssl.enable", "true");
      props.put("mail.smtp.ssl.trust", host);  
      
      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  
         protected PasswordAuthentication getPasswordAuthentication() {  
        	 return new PasswordAuthentication("","");  
         }  
       });  
      
      session.setDebug(true);
      
     //compose the message  
//      try{  
    	  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
         message.setSubject("Ping");  
         message.setText("Hello, this is example of sending email  ");  
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
  
//      }catch (MessagingException mex) {
//    	  mex.printStackTrace();
//      }  
   }  
}  








