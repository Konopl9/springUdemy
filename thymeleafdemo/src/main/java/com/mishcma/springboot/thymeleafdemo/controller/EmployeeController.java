package com.mishcma.springboot.thymeleafdemo.controller;

import com.mishcma.springboot.thymeleafdemo.entity.Employee;
import com.mishcma.springboot.thymeleafdemo.service.EmployeeService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  private final EmployeeService employeeService;
  // load employee data
  private List<Employee> employees;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  // add mapping for "/list"
  @GetMapping("/list")
  public String listEmployees(Model model) {
    List<Employee> employees = employeeService.findAll();

    model.addAttribute("employees", employees);

    return "employees/list-employees";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    Employee employee = new Employee();

    model.addAttribute("employee", employee);

    return "employees/employee-form";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    logger.info(String.valueOf(employee));
    employeeService.save(employee);

    return "redirect:/employees/list";
  }
}
