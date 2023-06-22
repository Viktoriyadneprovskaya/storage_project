package com.example.storage_project.dao.impl;

import com.example.storage_project.Contractors;
import com.example.storage_project.Employee;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.command.EmployeeUpdateCommand;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void deleteEmployeeById(Long id);
    void updateEmployeeById(Long id, EmployeeUpdateCommand command);
}
