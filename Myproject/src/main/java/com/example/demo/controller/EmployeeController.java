package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    //handler method to handle list Employees and return mode and view
    @GetMapping("/employees")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {
        //CREATE EMPLOYEE OBJECT TO HOLD EMPLOYEE FORM DATA
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

}