package com.example.storage_project.dao;

import com.example.storage_project.model.security.Role;

import java.util.Optional;

public interface RoleDao {
    Optional<Role> findRoleByName(String name);
}
