package com.spring.springprac.controller;

import com.spring.springprac.entity.Employer;
import com.spring.springprac.repository.EmployerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @PostMapping("/user")
    public ResponseEntity<String> user(@RequestBody @Valid Employer user) {
        employerRepository.save(user);

        return new ResponseEntity<>("success", HttpStatus.OK);

    }

    @GetMapping("/u")
    public String user12() {
        return "success";
    }

    @GetMapping("/join")
    public ResponseEntity<Object> join() {
        List<Object> list = employerRepository.findByInnerJoin();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
