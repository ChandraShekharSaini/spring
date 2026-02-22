package com.spring.springprac.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmployerNotFoundException {

    private String message;
    private String code;
    private Integer status;
    private String requestUrl;
    private LocalDateTime dateTime;

}
