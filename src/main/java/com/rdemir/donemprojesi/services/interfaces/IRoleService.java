package com.rdemir.donemprojesi.services.interfaces;

import com.rdemir.donemprojesi.entities.Role;

import java.util.List;

public interface IRoleService<T> {

    List<T> getRoles();

    Role getRole(Long id);

    Role save(T t);

    void delete(Long id);

}
