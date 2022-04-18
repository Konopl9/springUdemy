package com.mishcma.springboot.thymeleafdemo.controller;

import com.mishcma.springboot.thymeleafdemo.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        Employee employee1 = new Employee(1, "Maksym", "Mishchenko", "maksym.mishchenko@gmail.com");
        Employee employee2 = new Employee(2, "Maksym", "Mishchenko", "maksym.mishchenko@gmail.com");
        Employee employee3 = new Employee(3, "Maksym", "Mishchenko", "maksym.mishchenko@gmail.com");

        employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
