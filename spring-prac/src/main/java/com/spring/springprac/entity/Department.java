package com.spring.springprac.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Table(name = "department_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "dep_loc", nullable = false)
    @NotBlank(message = "Location cannot be empty")
    @Size(min = 2, max = 50, message = "Location must be between 2 and 50 characters")
    private String location;

    @Column(name = "dep_name", nullable = false)
    @NotBlank(message = "Department name cannot be empty")
    @Size(min = 2, max = 50, message = "Department name must be between 2 and 50 characters")
    private String department;


}
