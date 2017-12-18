package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.interfaces.entities.IUser;

import javax.persistence.*;

@Entity
@Table(name = "HBYS_USER", uniqueConstraints = @UniqueConstraint(name = "UNQ_USERNAME", columnNames = {"username"}))
public class UserImp extends BaseEntity implements IUser {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private RoleImp role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONEL_ID", foreignKey = @ForeignKey(name = "FK_USER_PERSONEL"))
    private PersonelImp personel;

    public UserImp() {
    }

    public UserImp(String username, String name, String surname, String password, Boolean enabled, RoleImp role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RoleImp getRole() {
        return role;
    }

    public void setRole(RoleImp role) {
        this.role = role;
    }

    public PersonelImp getPersonel() {
        return personel;
    }

    public void setPersonel(PersonelImp personel) {
        this.personel = personel;
    }
}
