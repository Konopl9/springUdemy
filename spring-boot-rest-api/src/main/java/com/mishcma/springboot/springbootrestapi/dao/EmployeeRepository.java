package com.mishcma.springboot.springbootrestapi.dao;

import com.mishcma.springboot.springbootrestapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}