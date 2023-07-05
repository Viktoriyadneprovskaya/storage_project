package com.example.storage_project.controller;

import com.example.storage_project.command.EmployeeCommand;
import com.example.storage_project.command.EmployeeUpdateCommand;
import com.example.storage_project.model.Employee;
import com.example.storage_project.model.JobTitle;
import com.example.storage_project.service.EmployeeService;
import com.example.storage_project.service.JobTitleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final JobTitleService jobTitleService;

    public EmployeeController(EmployeeService employeeService, JobTitleService jobTitleService) {
        this.employeeService = employeeService;
        this.jobTitleService = jobTitleService;
    }

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<JobTitle> jobTitles = jobTitleService.getAllJobTitles();
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("employees", employees);
        return "employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")EmployeeCommand command) {
        JobTitle jobTitle = jobTitleService.getJobTitleById(command.getJobTitle());
        Employee employee =Employee.builder()
                .username(command.getUsername())
                .password(command.getPassword())
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .jobTitle(jobTitle)
                .build();
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") EmployeeUpdateCommand command) {
        Long id= command.getId();
        employeeService.updateEmployeeById(command);
        return "redirect:/employees";
    }
}
