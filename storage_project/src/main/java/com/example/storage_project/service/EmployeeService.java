package com.example.storage_project.service;

import com.example.storage_project.command.employee.EmployeeUpdateCommand;
import com.example.storage_project.dao.employees.EmployeeDao;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.model.security.Role;
import com.example.storage_project.model.security.SecurityUser;
import com.example.storage_project.util.UserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {
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
    public Employee getEmployeeById(Long id){
        return employeeDao.getEmployeeById(id);
    }
    public List<Role> getAllRoles(){
        return employeeDao.getAllRoles();
    }
    public Role getRoleById(Long roleId) {
        return employeeDao.getRoleById(roleId);
    }
    public Optional<Employee> findEmployeeByUsername(String username) {
        return employeeDao.findEmployeeByUsername(username);
    }
    public void updateEmployeeByPassword(String password, Long id){
        employeeDao.updateEmployeeByPassword(password,id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeDao.findEmployeeByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Employee with "+ username + "hasn't been found"));
        SecurityUser securityUser = UserFactory.toSecurityUser(employee);
        return securityUser;
    }
}
