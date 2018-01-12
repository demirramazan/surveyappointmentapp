package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.Personel;
import com.rdemir.donemprojesi.entities.Role;

import java.util.List;

public interface IUser {

    String getUsername();

    String getPassword();

    Boolean getEnabled();

    String getName();

    String getSurname();

    List<Role> getRole();

    Personel getPersonel();

}
