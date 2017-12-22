package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION", schema = "hbystetkik")
public class PermissionImp extends BaseEntity {
    @Column(name = "PERMISSION_ADI")
    private String permissionAdi;

    @Column(name = "PATH")
    private String path;

    @OneToOne
    @JoinColumn(name = "ROLE_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_ROLE"))
    private RoleImp role;

    @OneToOne
    @JoinColumn(name = "MENU_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_MENU"))
    private MenuImp menu;

    @OneToOne
    @JoinColumn(name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_USER"))
    private UserImp user;

    public PermissionImp() {
    }

    public PermissionImp(String permissionAdi, String path, RoleImp role, MenuImp menu, UserImp user) {
        this.permissionAdi = permissionAdi;
        this.path = path;
        this.role = role;
        this.menu = menu;
        this.user = user;
    }


    public String getPermissionAdi() {
        return permissionAdi;
    }

    public void setPermissionAdi(String permissionAdi) {
        this.permissionAdi = permissionAdi;
    }

    public RoleImp getRole() {
        return role;
    }

    public void setRole(RoleImp role) {
        this.role = role;
    }

    public MenuImp getMenu() {
        return menu;
    }

    public void setMenu(MenuImp menu) {
        this.menu = menu;
    }

    public UserImp getUser() {
        return user;
    }

    public void setUser(UserImp user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
