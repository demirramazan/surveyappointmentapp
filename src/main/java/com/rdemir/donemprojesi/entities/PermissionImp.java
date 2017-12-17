package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.interfaces.entities.IPermission;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION",schema = "hbystetkik")
public class PermissionImp extends BaseEntity implements IPermission {
    @Column(name = "PERMISSION_ADI")
    String permissionAdi;

    @OneToOne
    @JoinColumn(name = "ROLE_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_ROLE"))
    private RoleImp role;

    @OneToOne
    @JoinColumn(name = "MENU_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_MENU"))
    private MenuImp menu;

    public PermissionImp() {
    }

    public PermissionImp(String permissionAdi, RoleImp role, MenuImp menu) {
        this.permissionAdi = permissionAdi;
        this.role = role;
        this.menu = menu;
    }

    @Override
    public RoleImp getRole() {
        return role;
    }

    public void setRole(RoleImp role) {
        this.role = role;
    }

    @Override
    public MenuImp getMenu() {
        return menu;
    }

    public void setMenu(MenuImp menu) {
        this.menu = menu;
    }

    @Override
    public String getPermissionAdi() {
        return permissionAdi;
    }

    public void setPermissionAdi(String permissionAdi) {
        this.permissionAdi = permissionAdi;
    }
}
