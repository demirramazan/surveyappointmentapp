package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.MenuImp;

public interface IMenu {

    String getMenuAdi();

    MenuImp getParent();

    int getMenuIndex();

    String getModule();

    String getIcon();

}
