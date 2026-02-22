package com.spring.springprac.service;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDetails {

    private String sendername;
    private String recipient;
    private String msgBody;
    private String subject;


}
