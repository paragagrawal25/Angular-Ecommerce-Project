package com.example.demo.Controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.User;
import com.example.demo.service.MailService;

@RestController
@CrossOrigin("*")
public class RegistrationController
{
	@Autowired
	private MailService notificationService;
	
	@PostMapping("/contactUs/send-mail")
	public String send(@RequestBody User user)
	{
		System.out.println(user.getEmail());
		try
		{
			notificationService.sendEmail(user);
			notificationService.sendEmailToEzeeShop(user);
		} 
		catch (MailException mailException)
		{
			System.out.println(mailException);
		}
		
		return "Successfully Submitted.";
	}

	
	@PostMapping("/contactUs/send-mail-attachment")
	public String sendWithAttachment(@RequestBody User user) throws MessagingException
	{
		try
		{
			notificationService.sendEmailWithAttachment(user);
			
		} catch (MailException mailException)
		{
			System.out.println(mailException);
		}
		
		return "Successfully Submitted.";
	}
}
