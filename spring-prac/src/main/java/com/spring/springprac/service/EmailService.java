package com.spring.springprac.service;


import org.springframework.stereotype.Service;


public interface EmailService {

    String sendSimpleMail(EmailDetails details);

}
