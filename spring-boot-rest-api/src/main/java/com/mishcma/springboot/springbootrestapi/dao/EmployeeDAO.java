package com.mishcma.springboot.springbootrestapi.dao;

import com.mishcma.springboot.springbootrestapi.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
