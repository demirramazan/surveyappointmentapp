package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.PersonelImp;
import com.rdemir.donemprojesi.entities.RoleImp;

public interface IUser {

    String getUsername();

    String getPassword();

    Boolean getEnabled();

    String getName();

    String getSurname();

    RoleImp getRole();

    PersonelImp getPersonel();

}
