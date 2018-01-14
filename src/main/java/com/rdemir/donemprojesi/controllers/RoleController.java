package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.interfaces.services.IRoleService;
import com.rdemir.donemprojesi.scope.ScopeName;
import com.rdemir.donemprojesi.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("roleBean")
@Scope(ScopeName.SESSION)
public class RoleController {

    @Autowired
    private IRoleService roleService;

    private String code;

    private String name;

    private String description;

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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
