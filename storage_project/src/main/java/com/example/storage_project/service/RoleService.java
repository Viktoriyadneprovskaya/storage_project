package com.example.storage_project.service;

import com.example.storage_project.dao.RoleDao;
import com.example.storage_project.model.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    public Optional<Role> findRoleByName(String name){
        return roleDao.findRoleByName(name);
    }
}
