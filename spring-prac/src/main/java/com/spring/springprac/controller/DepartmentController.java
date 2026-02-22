package com.spring.springprac.controller;


import com.spring.springprac.entity.Department;
import com.spring.springprac.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/dept")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
        return new ResponseEntity<Department>(department, HttpStatus.CREATED);
    }

}
