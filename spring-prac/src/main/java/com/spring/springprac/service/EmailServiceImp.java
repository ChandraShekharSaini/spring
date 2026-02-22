package com.spring.springprac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
//public class EmailServiceImp implements EmailService {

//    private Logger log = LoggerFactory.getLogger(EmailServiceImp.class);

//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String sender;
//
//    @Override
//    public String sendSimpleMail(EmailDetails details) {
//
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//
//            message.setFrom(sender);
//            message.setSubject(details.getSubject());
//            message.setTo(details.getRecipient());
//            message.setText(details.getMsgBody());
//
//            mailSender.send(message);
//
//            return "Email sent successfully";
//
//        } catch (RuntimeException e) {
//            log.error("Error In sending Mail: {}", e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
//}
