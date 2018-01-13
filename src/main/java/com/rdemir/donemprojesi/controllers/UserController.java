package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Component("userBean")
@Scope(ScopeName.SESSION)
public class UserController {

    @Autowired
    private IUserService userService;

    private String deneme = "RAMAZANN";

    public User user;
    private String username;
    private String password;

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

    public UserController() {

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

    public String getDeneme() {
        return deneme;
    }

    public void setDeneme(String deneme) {
        this.deneme = deneme;
    }
}
