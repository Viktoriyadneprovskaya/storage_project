package com.example.storage_project.controller;

import com.example.storage_project.command.employee.EmployeeDTO;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.model.security.SecurityUser;
import com.example.storage_project.service.EmployeeService;
import com.example.storage_project.util.UserFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee_page")
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
    @GetMapping
    public String getEmployeePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser principal = (SecurityUser) authentication.getPrincipal();
        Employee employee = employeeService.getEmployeeById(principal.getId());
        EmployeeDTO employeeDTO = UserFactory.employeeToDTO(employee);
        model.addAttribute("employee",employeeDTO);
        return "employee_page";
    }
}
