package com.example.storage_project.controller;

import com.example.storage_project.command.EmployeeDTO;
import com.example.storage_project.model.Employee;
import com.example.storage_project.service.EmployeeService;
import com.example.storage_project.util.UserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}/{username}")
    public String load(@PathVariable Long id, @PathVariable String username, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDTO employeeDTO = UserFactory.employeeToDTO(employee);
        model.addAttribute("employee",employeeDTO);
        return "employee_page";
    }
}
