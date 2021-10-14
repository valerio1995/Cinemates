package mvp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class SendMailPresenter {
	
	public boolean isNotEmptyField(String fieldObject, String fieldBody) {
		if(fieldObject.equals("") || fieldBody.equals("")){
			return false;
		}else {
			return true;
		} 
	}
	
	public void sendMail(List<User> listUsers, String fieldObject, String fieldMessage, String adminEmail) throws MessagingException{
		/*You need turn off your antivirus*/
		
		for(int index=0; index<listUsers.size();index++) {
			User user = new User();
			user = listUsers.get(index);
			String to = user.getEmail();
		    String subject = fieldObject;
		    String msg = fieldMessage;
		    final String from = "valerio.panzera@gmail.com";
		    final  String password ="Pandemonium94";


		    Properties props = new Properties();  
		    props.setProperty("mail.transport.protocol", "smtp");     
		    props.setProperty("mail.host", "smtp.gmail.com");  
		    props.put("mail.smtp.auth", "true");  
		    props.put("mail.smtp.port", "465");  
		    props.put("mail.debug", "true");  
		    props.put("mail.smtp.socketFactory.port", "465");  
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		    props.put("mail.smtp.socketFactory.fallback", "false");  
		    Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {
		       protected PasswordAuthentication getPasswordAuthentication() {  
		       return new PasswordAuthentication(from,password);  
		   }  
		   });  

		     
		   Transport transport = session.getTransport();  
		   InternetAddress addressFrom = new InternetAddress(from);  

		   MimeMessage message = new MimeMessage(session);  
		   message.setSender(addressFrom);  
		   message.setSubject(subject);  
		   message.setContent(msg, "text/plain");  
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

		   transport.connect();  
		   Transport.send(message);  
		   transport.close();
		   System.out.println("Email inviata a: "+user.getEmail());
		}
		
		AdministrationView administrationView = new AdministrationView("null");
		administrationView.showSuccessSendMessage();
		
 }  

	
	
	
	
	
}
