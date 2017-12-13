package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.interfaces.entities.IRole;

import javax.persistence.*;

@Entity
@Table(name = "HBYS_ROLE")
public class RoleImp extends BaseEntity implements IRole {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    public RoleImp(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }


    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
