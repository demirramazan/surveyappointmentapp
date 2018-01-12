package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import org.primefaces.model.menu.*;
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
    //    DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
//
//    DefaultMenuItem item = new DefaultMenuItem("External");
//item.setUrl("http://www.primefaces.org");
//item.setIcon("ui-icon-home");
//firstSubmenu.addElement(item);
//
//model.addElement(firstSubmenu);
//
//    //Second submenu
//    DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
//public class MenuBean {
//    private MenuModel model;
//
//    public MenuBean() {
//        model = new DefaultMenuModel();
//
//        //First submenu
//        Submenu submenu = new Submenu();
//        submenu.setLabel("Dynamic Submenu 1");
//
//        MenuItem item = new MenuItem();
//        item.setValue("Dynamic Menuitem 1.1");
//        item.setUrl("#");
//        submenu.getChildren().add(item);
//
//        model.addSubmenu(submenu);
//
//        //Second submenu
//        submenu = new Submenu();
//        submenu.setLabel("Dynamic Submenu 2");
//
//        item = new MenuItem();
//        item.setValue("Dynamic Menuitem 2.1");
//        item.setUrl("#");
//        submenu.getChildren().add(item);
//
//        item = new MenuItem();
//        item.setValue("Dynamic Menuitem 2.2");
//        item.setUrl("#");
//        submenu.getChildren().add(item);
//
//        model.addSubmenu(submenu);
//    }
//
//    public MenuModel getModel() {
//        return model;
//    }
//}
}
