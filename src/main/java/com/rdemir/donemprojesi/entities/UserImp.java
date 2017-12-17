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

    @Override
    public RoleImp getRole() {
        return role;
    }

    public void setRole(RoleImp role) {
        this.role = role;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Boolean getEnabled() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public PersonelImp getPersonel() {
        return personel;
    }

    public void setPersonel(PersonelImp personel) {
        this.personel = personel;
    }

    @Override
    public String toString() {
        return "UserImp{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
