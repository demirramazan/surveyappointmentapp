/*
package com.rdemir.donemprojesi.config;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import com.rdemir.donemprojesi.interfaces.services.IPermissionService;
import com.rdemir.donemprojesi.interfaces.services.IRoleService;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SessionInitializer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    IUserService userService;
    @Autowired
    IMenuService moduleService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IPermissionService permissionService;

    private User user;
    private Role role;
    private HttpSession httpSession;
    private DefaultMenuModel menuModel = new DefaultMenuModel();
    private List<Menu> authMenus = null;
    private List<Permission> permissionList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }


    public DefaultMenuModel getMenuModel() {
        return menuModel;
    }

    public List<Menu> getAuthMenus() {
        return authMenus;
    }


    public void showFieldDets() {
        String componentID = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("componentID");
        UIInput component = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent(componentID.replaceAll("_input", ""));

        if (component != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, component.getValue() + " | " + component.getValueExpression("value"), null));
        }
    }

    public void refreshPage() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    public void exit() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.invalidateSession();
//        httpSession.invalidate();
        context.redirect("/login.xhtml");
        menuModel = null;
    }


    public void setMenuModel() {
        role = user.getRole();
        String roleCode;
        if (role != null) {
            menuModel = new DefaultMenuModel();
            roleCode = role.getCode();
            DefaultMenuItem menuHome = new DefaultMenuItem("Anasayfa");
            menuHome.setUrl("/home.xhtml");
            menuHome.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
            menuHome.setIcon("fa fa-home");
            menuModel.addElement(menuHome);

            DefaultSubMenu menuHastaIslem = new DefaultSubMenu("Hasta Kabul İşlemleri");
            menuHastaIslem.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
            menuModel.addElement(menuHastaIslem);

            DefaultSubMenu menuRandevu = new DefaultSubMenu("Randevu İşlemleri");
            menuRandevu.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
            menuHastaIslem.setIcon("ui-icon-calendar");
            menuModel.addElement(menuRandevu);

            if (roleCode.equals("ADMIN")) {
                DefaultSubMenu mainMenu = new DefaultSubMenu("Tanımlama İşlemleri");
                mainMenu.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuModel.addElement(mainMenu);

                DefaultMenuItem menuItem = new DefaultMenuItem("Kullanıcı Tanım");
                menuItem.setUrl("/UserTanim.xhtml");
                menuItem.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem);

                DefaultMenuItem menuItem2 = new DefaultMenuItem("Role Tanım");
                menuItem2.setUrl("/RoleTanim.xhtml");
                menuItem2.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem2.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem2);

                DefaultMenuItem menuItem3 = new DefaultMenuItem("Menu Tanım");
                menuItem3.setUrl("/MenuTanim.xhtml");
                menuItem3.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem3.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem3);

                DefaultMenuItem menuItem4 = new DefaultMenuItem("Permission Tanım");
                menuItem4.setUrl("/PermissionTanim.xhtml");
                menuItem4.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem4.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem4);

                DefaultMenuItem menuItem5 = new DefaultMenuItem("Personel Tanım");
                menuItem5.setUrl("/PersonelTanim.xhtml");
                menuItem5.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem5.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem5);

                DefaultMenuItem menuItem6 = new DefaultMenuItem("Tetkik Tanım");
                menuItem6.setUrl("/TetkikTanim.xhtml");
                menuItem6.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem6.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem6);

                DefaultMenuItem menuItem7 = new DefaultMenuItem("Birim Tanım");
                menuItem7.setUrl("/BirimTanim.xhtml");
                menuItem7.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem7.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem7);

                DefaultMenuItem menuItem8 = new DefaultMenuItem("Salon Tanım");
                menuItem8.setUrl("/SalonTanim.xhtml");
                menuItem8.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem8.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem8);

                DefaultMenuItem menuItem9 = new DefaultMenuItem("Cihaz Tanım");
                menuItem9.setUrl("/CihazTanim.xhtml");
                menuItem9.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem9.setIcon("ui-icon-person");
                mainMenu.addElement(menuItem9);

                DefaultMenuItem menuItem14 = new DefaultMenuItem("Randevu Şablon");
                menuItem14.setUrl("/RandevuSablon.xhtml");
                menuItem14.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem14.setIcon("ui-icon-calendar");
                menuRandevu.addElement(menuItem14);

                DefaultMenuItem menuItem15 = new DefaultMenuItem("Randevu Seans");
                menuItem15.setUrl("/RandevuSeans.xhtml");
                menuItem15.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem15.setIcon("ui-icon-calendar");
                menuRandevu.addElement(menuItem15);
            }
            if (roleCode.equals("ADMIN") || roleCode.equals("SEKRETER")) {

                DefaultMenuItem menuItem9 = new DefaultMenuItem("Hasta Tanım");
                menuItem9.setUrl("/HastaTanim.xhtml");
                menuItem9.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem9.setIcon("ui-icon-person");
                menuHastaIslem.addElement(menuItem9);

                DefaultMenuItem menuItem10 = new DefaultMenuItem("Hasta Başvuru");
                menuItem10.setUrl("/HastaBasvuru.xhtml");
                menuItem10.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem10.setIcon("ui-icon-person");
                menuHastaIslem.addElement(menuItem10);

            }
            if (roleCode.equals("ADMIN") || roleCode.equals("DOKTOR")) {
                DefaultMenuItem menuItem11 = new DefaultMenuItem("Hasta Tetkik İstem");
                menuItem11.setUrl("/HastaTetkikIstem.xhtml");
                menuItem11.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem11.setIcon("ui-icon-person");
                menuHastaIslem.addElement(menuItem11);

                DefaultMenuItem menuItem13 = new DefaultMenuItem("Tetkik Rapor");
                menuItem13.setUrl("/TetkikRapor.xhtml");
                menuItem13.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem13.setIcon("ui-icon-person");
                menuItem13.setParam("DOKTOR_MU", true);
                menuHastaIslem.addElement(menuItem13);
            }
            if (roleCode.equals("ADMIN") || roleCode.equals("TEKNISYEN")) {
                DefaultMenuItem menuItem12 = new DefaultMenuItem("Tetkik Kabul");
                menuItem12.setUrl("/TetkikKabul.xhtml");
                menuItem12.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem12.setIcon("ui-icon-person");
                menuHastaIslem.addElement(menuItem12);
            }
            if (roleCode.equals("ADMIN") || roleCode.equals("RAD_SEKRETER")) {
                DefaultMenuItem menuItem16 = new DefaultMenuItem("Randevu Alma");
                menuItem16.setUrl("/Randevu.xhtml");
                menuItem16.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuItem16.setIcon("ui-icon-calendar");
                menuRandevu.addElement(menuItem16);
            }
            DefaultMenuItem menuItem16 = new DefaultMenuItem("Çıkış");
            menuItem16.setCommand("#{sessionInitializer.exit}");
            menuItem16.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
            menuItem16.setIcon("ui-icon-close");
            menuModel.addElement(menuItem16);

        }
//        authMenus = new ArrayList<>();
//        permissionList = permissionService.getUserRolePermissions(user, role);
//        for (Permission permission : permissionList) {
//            Menu menu = permission.getMenu();
//            authMenus.add(menu);
//        }
//        if (authMenus.size() > 0) {
//            for (Menu menu : authMenus) {
//                if (menu.getParentMenu() == null) {//Main Menu - Üst Menü
//                    DefaultSubMenu mainMenu = new DefaultSubMenu(menu.getMenuAdi());
//                    mainMenu.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
//                    menuModel.addElement(mainMenu);
//                    subMenuModel(mainMenu, menu);
//                }
//            }
//        }
    }


    private void subMenuModel(DefaultSubMenu currMenu, Menu currModule) {
        for (Menu menu : authMenus) {
            if (currModule.equals(menu.getParentMenu())) {
                if (menu.getParentMenu() != null && menu.getChildMenu() != null) {
                    DefaultSubMenu childMenu = new DefaultSubMenu(menu.getMenuAdi());
                    currMenu.addElement(childMenu);
                    subMenuModel(childMenu, menu);
                } else {
                    DefaultMenuItem menuItem = new DefaultMenuItem(menu.getMenuAdi());
//                    menuItem.setOnclick("$(this).addTab('pages/UserTanim.xhtml');");
                    menuItem.setCommand("pages/UserTanim.xhtml");
                    menuItem.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                    currMenu.addElement(menuItem);
                }
            }
        }
    }

    @Produces
    @Named
    public User getLoggedUser() {
        return getUser();
    }
}
*/
