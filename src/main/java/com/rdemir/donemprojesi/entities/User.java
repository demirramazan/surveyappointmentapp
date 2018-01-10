package com.rdemir.donemprojesi.entities;


import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "USER", uniqueConstraints = @UniqueConstraint(name = "UNQ_USERNAME", columnNames = {"username"}))
public class User extends BaseEntity {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @ManyToOne(cascade = MERGE)
    @JoinColumn(name = "USER_ROLE_ID", foreignKey = @ForeignKey(name = "FK_USER_ROLE_ID"))
    private Role role;

    @OneToOne
    @JoinColumn(name = "PERSONEL_ID", foreignKey = @ForeignKey(name = "FK_USER_PERSONEL"))
    private Personel personel;

    public User() {
    }

    public User(String username, String name, String surname, String password, Boolean enabled, Role role, Personel personel) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.personel = personel;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }
}
