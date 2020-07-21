package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.services.interfaces.IRoleService;
import com.rdemir.donemprojesi.repositories.RoleReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements IRoleService<Role> {
    @Autowired
    private RoleReporsitory roleReporsitory;

    @Override
    public List<Role> getRoles() {
        return roleReporsitory.findAll();
    }

    @Override
    public Role getRole(Long id) {
        return roleReporsitory.getOne(id);
    }

    @Override
    public Role save(Role role) {
        return roleReporsitory.save(role);
    }

    @Override
    public void delete(Long id) {
        roleReporsitory.deleteById(id);
    }
}
