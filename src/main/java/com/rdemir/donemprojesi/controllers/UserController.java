package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserController {

    @Autowired
    private IUserService userService;

    private String deneme = "RAMAZANN";

    public User user;

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
