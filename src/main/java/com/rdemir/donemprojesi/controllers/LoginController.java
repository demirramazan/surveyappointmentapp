//package com.rdemir.donemprojesi.controllers;
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//
//import javax.faces.application.NavigationHandler;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//
//@ManagedBean
//@SessionScoped
//public class LoginController {
//
//    public void login()  {
//
//        System.out.println("Login Metoduna Girildi");
//        try {
//
//            RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("/j_spring_security_check");
//
//            dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
//            FacesContext.getCurrentInstance().responseComplete();
//
//        } catch (ServletException | IOException ex) {
//            Logger.getLogger(LoginControlClass.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        /*finally {
//            return null;
//        }*/
//        System.out.println("Login Metodundan Çıkıldı");
//    }
//
//    public void authorizedUserControl(){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if(!authentication.getPrincipal().toString().equals("anonymousUser")){
//
//            NavigationHandler nh =  FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
//            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/takingAppointment.xhtml?faces-redirect=true");
//
//        }
//    }
//}
