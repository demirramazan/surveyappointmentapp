package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.config.SessionInitializer;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component("loginBean")
@Scope(ScopeName.SESSION)
public class LoginController {
    @Autowired
    private IUserService userService;
    @Inject
    private SessionInitializer sessionInitializer;

    private String username;
    private String password;
    private  String password1;
    private String password2;

    public void login() throws Exception {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        User user = userService.login(username, password, httpSession);
        if (user != null) {
            sessionInitializer.setMenuModel();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/home.jsf");
        }
    }

    public void logout() throws IOException {
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
    public void changePassword() throws Exception{
        User user = sessionInitializer.getLoggedUser();
        logout();
        user.setPassword(password1);
        userService.save(user);
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public LoginController() {
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
