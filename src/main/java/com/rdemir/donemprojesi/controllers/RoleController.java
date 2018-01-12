package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.interfaces.services.IRoleService;
import com.rdemir.donemprojesi.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "roleBean")
@ViewScoped
public class RoleController {

    @Autowired
    private IRoleService roleService;

    private Role role;

    private RoleType roleType;

    public void setRole(Role role) {
        this.role = role;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public RoleController(Role role) {
        this.role = role;
    }

    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    public Role saveRole() {
        return roleService.save(role);
    }

    public Role getRole() {
        return roleService.getRole(role.getId());
    }

    public void deleteRole() {
        roleService.delete(role.getId());
    }
}
