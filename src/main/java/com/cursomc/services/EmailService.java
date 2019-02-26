package com.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.cursomc.domain.Pedido;

public interface EmailService {
	
	//Email plano
	void sendOrderConfirEmail(Pedido obj);	
	void sendEmail(SimpleMailMessage msg);
	
	//Email html
	void sendOrderConfirHtmlEmail(Pedido obj);	
	void sendHtmlEmail(MimeMessage msg);

}
