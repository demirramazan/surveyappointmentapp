package com.rdemir.donemprojesi.controllers;


import com.rdemir.donemprojesi.config.SessionInitializer;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginController  {
    @Autowired
    private IUserService userService;
    @Inject
    private SessionInitializer sessionInitializer;

    private String username;
    private String password;

    public void login() throws Exception {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        User user = userService.login(username, password, httpSession);
        if (user != null) {
            sessionInitializer.setMenuModel();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/home.jsf");
        }
    }

    public void logout(String source) throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.invalidateSession();
        context.redirect(context.getRequestContextPath() + "/login.jsf");
    }

    public void checkSessionForUser() throws IOException {
        // Kullanıcı daha önce session almış ve login olmuş ise direk ana sayfaya yönlendiriyoruz
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession httpSession = (HttpSession) externalContext.getSession(false);
        if (httpSession != null && httpSession.getAttribute("user") != null) {
            externalContext.redirect("/home.jsf");
        }
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
}
