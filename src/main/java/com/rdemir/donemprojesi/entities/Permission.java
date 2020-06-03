package com.rdemir.donemprojesi.entities;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION")
public class Permission extends BaseEntity {
    @Column(name = "PERMISSION_ADI")
    private String permissionAdi;

    @OneToOne
    @JoinColumn(name = "ROLE_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_ROLE"))
    private Role role;

    @OneToOne
    @JoinColumn(name = "MENU_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_MENU"))
    private Menu menu;

    @OneToOne
    @JoinColumn(name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_PERMISSION_USER"))
    private User user;

    public Permission() {
    }

    public Permission(String permissionAdi, Role role, Menu menu, User user) {
        this.permissionAdi = permissionAdi;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
