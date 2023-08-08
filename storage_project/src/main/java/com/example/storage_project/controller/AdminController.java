package com.example.storage_project.controller;

import com.example.storage_project.command.employee.EmployeeDTO;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.service.EmployeeService;
import com.example.storage_project.util.UserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final EmployeeService employeeService;

    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}/{username}")
    public String init(@PathVariable Long id, @PathVariable String username, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDTO employeeDTO = UserFactory.employeeToDTO(employee);
        model.addAttribute("employee",employeeDTO);
        return "admin";
    }
}
