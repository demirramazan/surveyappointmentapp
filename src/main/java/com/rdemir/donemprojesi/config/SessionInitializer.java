package com.rdemir.donemprojesi.config;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import com.rdemir.donemprojesi.interfaces.services.IPermissionService;
import com.rdemir.donemprojesi.interfaces.services.IRoleService;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.util.ScopeUtil;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
    private HttpSession httpSession;
    private DefaultMenuModel menuModel = new DefaultMenuModel();
    private List<Menu> authModules;
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


    public List<Menu> getAuthModules() {
        return authModules;
    }


    public void showFieldDets() throws IOException {
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
        context.redirect("/login.xhtml");
    }


    public void setMenuModel() {
        permissionList = permissionService.getUserPermissions(user);

        for (Permission permission : permissionList) {
            Menu menu = permission.getMenu();
            if (menu.getParentMenu() == null) {//Main Menu - Üst Menü
                DefaultSubMenu mainMenu = new DefaultSubMenu(menu.getMenuAdi());
                mainMenu.setId(FacesContext.getCurrentInstance().getViewRoot().createUniqueId());
                menuModel.addElement(mainMenu);
                arrangeMenuModel(mainMenu, menu);
            }
        }
    }

    private void arrangeMenuModel(DefaultSubMenu currMenu, Menu currModule) {
        for (Menu module : authModules) {
            if (currModule.equals(module.getParentMenu())) {
                DefaultSubMenu subMenu = new DefaultSubMenu(module.getMenuAdi());
                currMenu.addElement(subMenu);
                arrangeMenuModel(subMenu, module);

//                    currMenu.addElement(menuItem);
            }
        }
    }

//    @Produces
//    @LoggedUser
//    @Named
//    public User getLoggedUser() {
//        return getUser();
//    }


}