package com.mishcma.springboot.springbootrestapi.service;

import com.mishcma.springboot.springbootrestapi.entity.Employee;
import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
