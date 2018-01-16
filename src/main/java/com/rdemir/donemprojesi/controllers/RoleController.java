package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.interfaces.services.IRoleService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
    private Role selectedRole;
    private List<Role> roles;

    public RoleController() {
        if (role == null) {
            role = new Role();
            role.setName(name);
            role.setCode(code);
            role.setDescription(description);
        }
    }

    @PostConstruct
    public void init() {
        roles = roleService.getRoles();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role saveRole() {
        return roleService.save(role);
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

    public Role getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Role selectedRole) {
        this.selectedRole = selectedRole;
    }

    public void onRowSelect(SelectEvent event) {
        selectedRole = (Role) event.getObject();
        this.role = selectedRole;
    }
}
