package com.rdemir.donemprojesi.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MENU")
public class MenuImp extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String menuAdi;

    @Column(name = "MENU_INDEX")
    private int menuIndex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_ID")
    private MenuImp parent;

    @Column(length = 50)
    private String module;

    @Column(length = 30)
    private String icon;

    @Transient
    private List<MenuImp> items;

    public MenuImp() {
    }

    public MenuImp(String menuAdi, int menuIndex, MenuImp parent, String module, String icon) {
        this.menuAdi = menuAdi;
        this.menuIndex = menuIndex;
        this.parent = parent;
        this.module = module;
        this.icon = icon;
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

    public MenuImp getParent() {
        return parent;
    }

    public void setParent(MenuImp parent) {
        this.parent = parent;
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

    public List<MenuImp> getItems() {
        return items;
    }

    public void setItems(List<MenuImp> items) {
        this.items = items;
    }
}
