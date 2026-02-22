package com.spring.springprac.exception;

import com.spring.springprac.dtos.EmployerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployerNotFound.class)
    public ResponseEntity<EmployerNotFoundException> employerNotFound(EmployerNotFound e, HttpServletRequest req) {
        EmployerNotFoundException exception = buildException("Not Found", e.getMessage(), req.getRequestURI(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(),
                                error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    public EmployerNotFoundException buildException(String message, String code, String uri, HttpStatus status) {
        EmployerNotFoundException exception = new EmployerNotFoundException();
        exception.setMessage(message);
        exception.setCode(code);
        exception.setRequestUrl(uri);
        exception.setDateTime(LocalDateTime.now());
        return exception;
    }

}
