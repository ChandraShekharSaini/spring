package com.spring.springprac.controller;

import com.spring.springprac.service.EmailDetails;

import com.spring.springprac.service.MailerSendEmailService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v3")
@RestController
public class MailController {

    @Autowired
    MailerSendEmailService mailerSendEmailService;

    @PostMapping("/sendmail")
    public ResponseEntity<String> sendMail(@RequestBody EmailDetails emailDetails) throws Exception {

        String message = mailerSendEmailService.sendEmail(emailDetails.getSendername(), emailDetails.getRecipient(), emailDetails.getSubject(), emailDetails.getMsgBody());

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @Autowired
    ApplicationContext context;

    @PostConstruct
    public void check() {
        System.out.println(context.containsBean("mailSender"));
    }
}


