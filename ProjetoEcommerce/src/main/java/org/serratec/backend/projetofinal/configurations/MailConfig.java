package org.serratec.backend.projetofinal.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	//É IMPORTANTE SABER SE JÁ HÁ PROTOCOLO, CONHECER O HOST E A PORTA
	
	
	public void sendEmail(String para, String assunto, String texto){
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("serracommerce@gmail.com");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText("Dados da inscrição: \n " + texto + "\n\n\n Serratec Residência Teresópolis.");
		javaMailSender.send(message); 
		
		
		
		
	}
	

}