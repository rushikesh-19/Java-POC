package com.send.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SendingMail")
public class SendingMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String sender = request.getParameter("email");
		String msg = request.getParameter("message");

		final String reciptor = "rishigadekar19@gmail.com";
		final String password = "7387578218";
		
		Properties properties = System.getProperties();
	
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.post", "465");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.socketFactory.port", "465");
	
//		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		String host = "smtp.gmail.com";
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.starttls.enable", "true");	
		
		
//		Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(reciptor, password);
//			}
//		});
//		'
		
		Session session = Session.getDefaultInstance(properties);
		
		/*try {
			
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciptor));
			
			
			MimeBodyPart textPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			String final_text = "Name: "+ name +"\nEmail: "+ sender +"\nMessage: "+ msg;

			textPart.setText(final_text);

			message.setSubject(name);

			multipart.addBodyPart(textPart);

			message.setContent(multipart);
			
			
			Transport.send(message); 
			System.out.println("Doneeee");
			
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(sender));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciptor));
			
			message.setSubject(name);
			
			message.setText(msg);
			
			Transport.send(message);
			System.out.println("Done");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}