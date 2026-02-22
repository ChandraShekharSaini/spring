package com.spring.springprac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employer_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "user_email", nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String userPassword;

    @Column(name = "user_salary", nullable = false)
    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    @Max(value = 10000000, message = "Salary too large")
    private Integer userSalary;

    @Column(name = "user_cpi", nullable = false)
    @Min(value = 0, message = "CPI cannot be negative")
    @Max(value = 10, message = "CPI cannot be greater than 10")
    private Float userCpi;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dep_id" )
    private Department department;

}
