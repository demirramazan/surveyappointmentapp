package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userBean")
@Scope(ScopeName.SESSION)
public class UserController {

    @Autowired
    private IUserService userService;

    private User user;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Boolean enabled;
    private Role role;

    public UserController() {
        user = new User(username, password, name, surname, enabled, role, null);
    }

    public User findById(Long id) {
        return userService.getUserById(id);
    }

    public User save() {
        return userService.save(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
