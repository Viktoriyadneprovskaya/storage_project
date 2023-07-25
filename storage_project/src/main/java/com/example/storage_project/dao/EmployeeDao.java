package com.example.storage_project.dao;

import com.example.storage_project.model.Employee;
import com.example.storage_project.command.EmployeeUpdateCommand;
import com.example.storage_project.model.JobTitle;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    void updateEmployeeById(EmployeeUpdateCommand command);
    Optional<Employee> findEmployeeByUsername(String username);
    Employee getEmployeeById(Long id);
}
