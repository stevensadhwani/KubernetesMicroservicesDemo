package com.sadhwani.kubernetes.EmailService;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import javax.servlet.ServletRequest;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    private ServletRequest servletRequest;

    @Autowired
    public EmailService(JavaMailSender mail){
        this.javaMailSender = mail;
    }

    public void sendEmail(User user){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("KubernetesmicroservicesDemo@outlook.com");
        mail.setSubject("Payment details");
        mail.setText("Your payment was successful\n" +
                "\n sent from port" + servletRequest.getLocalPort());

        javaMailSender.send(mail);
    }

}
