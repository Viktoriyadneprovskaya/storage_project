package com.example.storage_project.service;

import com.example.storage_project.command.EmployeeUpdateCommand;
import com.example.storage_project.dao.EmployeeDao;
import com.example.storage_project.model.Employee;
import com.example.storage_project.model.JobTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees(){return employeeDao.getAllEmployees();}
    public void saveEmployee(Employee employee){
        employeeDao.saveEmployee(employee);
    }
    public void deleteEmployeeById(Long id){
        employeeDao.deleteEmployeeById(id);
    }
    public void updateEmployeeById(EmployeeUpdateCommand command){employeeDao.updateEmployeeById(command);}
}
