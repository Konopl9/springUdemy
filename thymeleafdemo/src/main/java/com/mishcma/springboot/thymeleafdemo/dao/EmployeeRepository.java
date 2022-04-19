package com.mishcma.springboot.thymeleafdemo.dao;

import com.mishcma.springboot.thymeleafdemo.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


// Change path from employees to members
// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();
}