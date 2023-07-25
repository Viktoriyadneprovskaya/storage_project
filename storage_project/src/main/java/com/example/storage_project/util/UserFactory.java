package com.example.storage_project.util;

import com.example.storage_project.command.EmployeeDTO;
import com.example.storage_project.model.Employee;
import com.example.storage_project.model.Role;
import com.example.storage_project.model.SecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserFactory {
    public static SecurityUser toSecurityUser(Employee employee){
        return new SecurityUser(
                employee.getUsername(),
                employee.getPassword(),
                getAuthoritiesFromRoles(employee.getRoles()),
                employee.getId()
        );
    }

    public static List<GrantedAuthority> getAuthoritiesFromRoles(List<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public static EmployeeDTO employeeToDTO(Employee employee){
        return EmployeeDTO.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .jobTitle(employee.getJobTitle().getName())
                .build();
    }
}
