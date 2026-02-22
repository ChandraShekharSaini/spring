package com.spring.springprac.repository;

import com.spring.springprac.entity.Department;
import com.spring.springprac.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    @Query("SELECT e FROM Employer e JOIN e.department d")
    List<Object> findByInnerJoin();
}
