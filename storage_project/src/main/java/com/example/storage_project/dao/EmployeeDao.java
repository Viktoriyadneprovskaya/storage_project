package com.example.storage_project.dao;

import com.example.storage_project.model.Employee;
import com.example.storage_project.command.EmployeeUpdateCommand;
import com.example.storage_project.model.JobTitle;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    void updateEmployeeById(EmployeeUpdateCommand command);

}
