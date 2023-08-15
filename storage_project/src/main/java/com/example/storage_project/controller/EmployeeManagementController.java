package com.example.storage_project.controller;

import com.example.storage_project.command.employee.EmployeeCommand;
import com.example.storage_project.command.employee.EmployeeUpdateCommand;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.model.employee.JobTitle;
import com.example.storage_project.model.security.Role;
import com.example.storage_project.service.EmployeeService;
import com.example.storage_project.service.JobTitleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeManagementController {
    private final EmployeeService employeeService;
    private final JobTitleService jobTitleService;

    public EmployeeManagementController(EmployeeService employeeService, JobTitleService jobTitleService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.jobTitleService = jobTitleService;
    }

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<JobTitle> jobTitles = jobTitleService.getAllJobTitles();
        List<Role> roles = employeeService.getAllRoles();
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("employees", employees);
        model.addAttribute("roles", roles);

        return "employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeCommand command) {
        employeeService.createEmployee(command);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") EmployeeUpdateCommand command) {
        employeeService.updateEmployeeById(command);
        return "redirect:/employees";
    }
}
