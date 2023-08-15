package com.example.storage_project.dao;

import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.command.employee.EmployeeUpdateCommand;
import com.example.storage_project.model.security.Role;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    void updateEmployeeById(EmployeeUpdateCommand command);
    Optional<Employee> findEmployeeByUsername(String username);
    Employee getEmployeeById(Long id);
    List<Role> getAllRoles();
    Role getRoleById(Long roleId);
}
