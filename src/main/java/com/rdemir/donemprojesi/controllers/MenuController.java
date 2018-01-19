package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component( "menuBean")
@Scope(ScopeName.SESSION)
public class MenuController {

    @Autowired
    private IMenuService menuService;
    private MenuModel model;

    private Menu menu;
    private List<Menu> menuList;
    private Menu selectedMenu;


    public MenuController() {
        menu = new Menu();
        model = new DefaultMenuModel();
    }

    @PostConstruct
    public void init() {
        menuList = menuService.getMenus();
    }

    public void save() {
        menuService.save(menu);
    }

    public void delete() {
        menuService.delete(menu.getId());
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getSelectedMenu() {
        return selectedMenu;
    }

    public void setSelectedMenu(Menu selectedMenu) {
        this.selectedMenu = selectedMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedMenu = (Menu) event.getObject();
        this.menu = selectedMenu;
    }
//
//    public List<Menu> getMenus() {
//
//
////<p:menu model="#{menuView.model}" />
//
////First submenu
//        DefaultSubMenu firstSubmenu = null;
//        List<Menu> menus = menuService.getMenus();
//        for (Menu menu : menus) {
//            firstSubmenu = new DefaultSubMenu(menu.getMenuAdi());
//
//        }
//        return menuService.getMenus();
//    }

}
