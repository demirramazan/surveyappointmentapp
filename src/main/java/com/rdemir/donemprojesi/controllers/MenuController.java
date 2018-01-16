package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuController {
    private Menu menu;

    @Autowired
    private IMenuService menuService;
    private MenuModel model;

    public MenuController(Menu menu) {
        this.menu = menu;
    }

    public MenuController() {
        model = new DefaultMenuModel();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getMenus() {


//<p:menu model="#{menuView.model}" />

//First submenu
        DefaultSubMenu firstSubmenu = null;
        List<Menu> menus = menuService.getMenus();
        for (Menu menu : menus) {
            firstSubmenu = new DefaultSubMenu(menu.getMenuAdi());

        }
        return menuService.getMenus();
    }

}
