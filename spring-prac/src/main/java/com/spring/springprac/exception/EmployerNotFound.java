package com.spring.springprac.exception;

public class EmployerNotFound extends RuntimeException {
    public EmployerNotFound() {
        super();
    }

    public EmployerNotFound(String message) {
        super(message);
    }
}
