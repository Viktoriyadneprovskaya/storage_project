package com.example.storage_project.controller;

import com.example.storage_project.command.employee.EmployeeDTO;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.model.security.SecurityUser;
import com.example.storage_project.service.EmployeeService;
import com.example.storage_project.util.UserFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employee_page")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    public EmployeeController(EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/{id}/{username}")
//    public String load(@PathVariable Long id, @PathVariable String username, Model model){
//        Employee employee = employeeService.getEmployeeById(id);
//        EmployeeDTO employeeDTO = UserFactory.employeeToDTO(employee);
//        model.addAttribute("employee",employeeDTO);
//        return "employees/employee_page";
//    }
    @GetMapping
    public String getEmployeePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser principal = (SecurityUser) authentication.getPrincipal();
        Employee employee = employeeService.getEmployeeById(principal.getId());
        EmployeeDTO employeeDTO = UserFactory.employeeToDTO(employee);
        model.addAttribute("employee",employeeDTO);
        return "employees/employee_page";
    }
    @PostMapping("/change_password")
    public String changePassword(Model model, @ModelAttribute("password") String password, @ModelAttribute("new_password") String newPassword){
//        Employee employeeOne = employeeService.findEmployeeByUsername(username)
//                .orElseThrow(()->new UsernameNotFoundException("Employee with "+ username + "hasn't been found"));
        String encodePassword = passwordEncoder.encode(password);
        String newEncodePassword = passwordEncoder.encode(newPassword);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser principal = (SecurityUser) authentication.getPrincipal();
        Employee employee = employeeService.getEmployeeById(principal.getId());
        EmployeeDTO employeeDTO = UserFactory.employeeToDTO(employee);
        if(!employee.getPassword().equals(encodePassword)){
            String massage = "You entered the wrong password";
            model.addAttribute("employee",employeeDTO);
            model.addAttribute("massage",massage);
            return "/employees/employee_page";
        }else {
            employeeService.updateEmployeeByPassword(newEncodePassword,employee.getId());
        }
        model.addAttribute("employee",employeeDTO);
        return "/employees/employee_page";
    }
}
