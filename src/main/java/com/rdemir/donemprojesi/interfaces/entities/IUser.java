package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.PersonelImp;
import com.rdemir.donemprojesi.entities.RoleImp;

import java.util.List;

public interface IUser {

    String getUsername();

    String getPassword();

    Boolean getEnabled();

    String getName();

    String getSurname();

    List<RoleImp> getRole();

    PersonelImp getPersonel();

}
