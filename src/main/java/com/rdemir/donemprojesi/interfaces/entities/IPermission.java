package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.MenuImp;
import com.rdemir.donemprojesi.entities.RoleImp;

public interface IPermission {
    String getPermissionAdi();

    RoleImp getRole();

    MenuImp getMenu();
}
