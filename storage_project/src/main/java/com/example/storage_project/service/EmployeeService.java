package com.example.storage_project.service;

import com.example.storage_project.command.employee.EmployeeCommand;
import com.example.storage_project.command.employee.EmployeeUpdateCommand;
import com.example.storage_project.dao.EmployeeDao;
import com.example.storage_project.model.employee.Employee;
import com.example.storage_project.model.employee.JobTitle;
import com.example.storage_project.model.security.Role;
import com.example.storage_project.model.security.SecurityUser;
import com.example.storage_project.util.UserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {
    private final EmployeeDao employeeDao;
    private final JobTitleService jobTitleService;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeDao employeeDao, JobTitleService jobTitleService, PasswordEncoder passwordEncoder) {
        this.employeeDao = employeeDao;
        this.jobTitleService = jobTitleService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Employee> getAllEmployees(){return employeeDao.getAllEmployees();}
    public void saveEmployee(Employee employee){
        employeeDao.saveEmployee(employee);
    }
    public void createEmployee(EmployeeCommand command){
        JobTitle jobTitle = jobTitleService.getJobTitleById(command.getJobTitle());
        Role role = getRoleById(command.getRole());
        List<Role> roleList = List.of(role);
        String encodePassword = passwordEncoder.encode(command.getPassword());
        Employee employee = Employee.builder()
                .username(command.getUsername())
                .password(encodePassword)
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .jobTitle(jobTitle)
                .roles(roleList)
                .build();
        saveEmployee(employee);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeDao.findEmployeeByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Employee with "+ username + "hasn't been found"));
        SecurityUser securityUser = UserFactory.toSecurityUser(employee);
        return securityUser;
    }
}
