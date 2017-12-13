package com.rdemir.donemprojesi.jsfs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@ManagedBean
@SessionScoped
public class LoginValidator {
    private Logger logger = LoggerFactory.getLogger(LoginValidator.class);

    public void login() {

        System.out.println("Login Metoduna Girildi");
        try {

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");

            dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception ex) {
            logger.error(LoginValidator.class.getName() + ex);

        }

        System.out.println("Login Metodundan Çıkıldı");
    }

    public void authorizedUserControl() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!authentication.getPrincipal().toString().equals("anonymousUser")) {

            NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/icerikEkle.xhtml?faces-redirect=true");

        }
    }
}
