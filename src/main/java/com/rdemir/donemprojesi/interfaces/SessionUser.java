package com.rdemir.donemprojesi.interfaces;


import com.rdemir.donemprojesi.entities.User;

import java.util.HashMap;
import java.util.List;

public interface SessionUser {

    User getUser();


    Object getId();


    String getUsername();


    List getAuthorities();


    String getName();


    String getSurname();


    HashMap<String,Object> getProperties();

}