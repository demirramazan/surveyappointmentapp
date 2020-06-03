package com.rdemir.donemprojesi.interfaces.services;

import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPermissionService<T> {
    List<Permission> getPermissions();

    List<Permission> getUserPermissions(User user);

    List<Permission> getUserRolePermissions(User user, Role role);

    Permission getPermission(Long id);

    Permission save(Permission menu);

    void delete(Long id);
}
