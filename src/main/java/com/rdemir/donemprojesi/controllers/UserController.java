package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.UserImp;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//@Component("userController")
//@Scope("session")
@ManagedBean
@SessionScoped
public class UserController {

    @Autowired
    private IUserService userService;

    private String deneme = "RAMAZANN";

    public UserImp userImp;

    public UserController() {
        this.userImp = new UserImp();
        userImp.setSurname("ramazan");
        userImp.setUsername("demir");
    }

    public UserImp findById(Long id) {
        return userService.getUserById(id);
    }

    public UserImp save(UserImp userImp) {
        return userService.save(userImp);
    }

    public UserImp getUserImp() {
        return userImp;
    }

    public void setUserImp(UserImp userImp) {
        this.userImp = userImp;
    }

    public String getDeneme() {
        return deneme;
    }

    public void setDeneme(String deneme) {
        this.deneme = deneme;
    }
}
