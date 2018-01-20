package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU_TANIM")
public class Menu extends BaseEntity<String> {
    @Column(length = 50, nullable = false, unique = true)
    private String menuAdi;

    @Column(name = "MENU_INDEX")
    private int menuIndex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHILD_ID", foreignKey = @ForeignKey(name = "FK_CHILD_MENU_ID"))
    private Menu childMenu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID", foreignKey = @ForeignKey(name = "FK_PARENT_MENU_ID"))
    private Menu parentMenu;

    @Column(length = 50)
    private String module;

    @Column(length = 30)
    private String icon;

    @Column(name = "PATH")
    private String path;

    @Column(name = "MENU_PARAM")
    private String menuParam;
    @Transient
    private List<Menu> items;

    public Menu() {
    }

    public Menu(String menuAdi, int menuIndex, Menu childMenu, Menu parentMenu, String module, String icon, String path, String menuParam, List<Menu> items) {
        this.menuAdi = menuAdi;
        this.menuIndex = menuIndex;
        this.childMenu = childMenu;
        this.parentMenu = parentMenu;
        this.module = module;
        this.icon = icon;
        this.path = path;
        this.menuParam = menuParam;
        this.items = items;
    }

    public String getMenuParam() {
        return menuParam;
    }

    public void setMenuParam(String menuParam) {
        this.menuParam = menuParam;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMenuAdi() {
        return menuAdi;
    }

    public void setMenuAdi(String menuAdi) {
        this.menuAdi = menuAdi;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Menu getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(Menu childMenu) {
        this.childMenu = childMenu;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }
}
