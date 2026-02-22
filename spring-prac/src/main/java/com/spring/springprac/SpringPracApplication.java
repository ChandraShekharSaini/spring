package com.spring.springprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringPracApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(SpringPracApplication.class, args);

        System.out.println("Has JavaMailSender bean: "
                + context.containsBean("javaMailSender"));
    }

}
