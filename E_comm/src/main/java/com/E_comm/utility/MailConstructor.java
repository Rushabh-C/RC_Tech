package com.E_comm.utility;

import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.E_comm.domain.Order;
import com.E_comm.domain.User;

@Component
public class MailConstructor {

	@Autowired
	private Environment env;

	@Autowired
	private TemplateEngine templateEngine;

	public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user,
			String password) {

		String url = contextPath + "/newUser?token=" + token;
		String message = "\nPlease Click On The Above Link or Paste in the URL field, To Verify Your Email and Edit Your Profile.\nYour Password:"
				+ password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("RC_Tech - New User Details");
		email.setText(url + message);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}
	
	public SimpleMailMessage passwordConstructResetTokenEmail(String contextPath, Locale locale, String token, User user,
			String password) {

		String url = contextPath + "/newUser?token=" + token;
		String message = "\nPlease Click On The Above Link or Paste in the URL field, To Verify Your Email and Edit Your Profile.\nYour Password:"
				+ password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("RC_Tech - Forgot Password Details");
		email.setText(url + message);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

	public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order, Locale locale) {
		Context context = new Context();
		context.setVariable("order", order);
		context.setVariable("user", user);
		context.setVariable("cartItemList", order.getCartItemList());
		String text = templateEngine.process("orderConfirmationEmailTemplate", context);
				
		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setTo(user.getEmail());
				email.setSubject("Order Confirmation - "+order.getId());
				email.setText(text, true);
				email.setFrom(new InternetAddress("rctechbusiness@gmail.com"));
			}
		};
		
		return messagePreparator;
	}

}
