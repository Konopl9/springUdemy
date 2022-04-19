package com.mishcma.springboot.thymeleafdemo.controller;

import com.mishcma.springboot.thymeleafdemo.entity.Employee;
import com.mishcma.springboot.thymeleafdemo.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // load employee data
    private List<Employee> employees;

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
