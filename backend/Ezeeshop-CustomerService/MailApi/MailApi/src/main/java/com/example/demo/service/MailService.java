package com.example.demo.service;

//This class contains two functions for E-mail sending. 
//One is of Simple Mail and other is of mail that contains an attachment.

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;

@Service
public class MailService
{

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(User user) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("EzeeShop Team");
		mail.setText("Thanks for contacting us.");

		javaMailSender.send(mail);
	}
	
	public void sendEmailToEzeeShop(User user) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		// mail.setTo();
		mail.setBcc("pswalia2u@gmail.com","ishu.agrawal.712@gmail.com", "mansianand996@gmail.com",
				"paraga23@gmail.com", "ankitchoudhary1.ac@gmail.com",
				"mozammil010@gmail.com",
				"shubhamsingh397@gmail.com");
		mail.setSubject(user.getSubject());
		mail.setText(user.getMessage()+"\n\n"+user.getName());

		javaMailSender.send(mail);
	}
	
	public void sendEmailWithAttachment(User user) throws MailException, MessagingException
	{

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(user.getEmail());
		helper.setSubject("EzeeShop Team");
		helper.setText("Thanks for contacting us.");

		ClassPathResource classPathResource = new ClassPathResource("MobiKwik.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
	}

}

