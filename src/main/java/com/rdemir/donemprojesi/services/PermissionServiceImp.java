package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IPermissionService;
import com.rdemir.donemprojesi.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImp implements IPermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission save(Permission menu) {
        return permissionRepository.saveAndFlush(menu);
    }

    @Override
    public void delete(Long id) {
        permissionRepository.delete(id);
    }

    @Override
    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public List<Permission> getUserPermissions(User user) {
        return permissionRepository.findByUser(user);
    }

    @Override
    public List<Permission> getUserRolePermissions(User user, Role role) {
        return permissionRepository.findByUserAndRole(user, role);
    }

    @Override
    public Permission getPermission(Long id) {
        return permissionRepository.getOne(id);
    }
}
