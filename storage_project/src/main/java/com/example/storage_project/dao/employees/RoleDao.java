package com.example.storage_project.dao.employees;

import com.example.storage_project.model.security.Role;

import java.util.Optional;

public interface RoleDao {
    Optional<Role> findRoleByName(String name);
    Role getRoleById(Long id);
}
