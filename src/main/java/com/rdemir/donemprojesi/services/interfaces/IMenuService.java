package com.rdemir.donemprojesi.services.interfaces;

import com.rdemir.donemprojesi.entities.Menu;

import java.util.List;

public interface IMenuService<T> {
    List<T> getMenus();

    Menu getMenu(Long id);

    Menu save(T t);

    void delete(Long id);
}
