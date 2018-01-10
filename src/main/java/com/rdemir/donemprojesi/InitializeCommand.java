package com.rdemir.donemprojesi;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.repositories.MenuRepository;
import com.rdemir.donemprojesi.repositories.PermissionRepository;
import com.rdemir.donemprojesi.repositories.RoleReporsitory;
import com.rdemir.donemprojesi.repositories.UserRepository;
import com.rdemir.donemprojesi.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeCommand implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleReporsitory roleReporsitory;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void run(String... args) {

        Role role = roleReporsitory.findByCode(RoleType.ADMIN.name());
        if (role == null) {
            role = new Role();
            role.setCode(RoleType.ADMIN.name());
            role.setName("Admin");
            role.setDescription("Admin Rolü");
            roleReporsitory.saveAndFlush(role);
        }
        User user = userRepository.findByUsername("rdemir");
        if (user == null) {
            user = new User();
            user.setName("Ramazan");
            user.setSurname("Demir");
            user.setUsername("rdemir");
            user.setPassword("123123");
            user.setEnabled(true);
            user.setRole(role);
            userRepository.saveAndFlush(user);
        }

        Menu menu = menuRepository.findByMenuAdi("Tanımlar");
        if (menu == null) {
            menu = new Menu();
            menu.setMenuAdi("Tanımlar");
            menu.setMenuIndex(1);
            menu.setIcon("");
            menu.setModule("tanimlar");
            menu.setParentMenu(null);
            menuRepository.save(menu);
        }

        Menu menuUser = new Menu();
        menuUser.setMenuAdi("Kullanıcı Tanım");
        menuUser.setMenuIndex(1);
        menuUser.setIcon("");
        menuUser.setModule("tanimlar");
        menu.setParentMenu(menu);
        menuRepository.save(menuUser);

        Menu menuRole = new Menu();
        menuRole.setMenuAdi("Rol Tanım");
        menuRole.setMenuIndex(2);
        menuRole.setIcon("");
        menuRole.setModule("tanimlar");
        menu.setParentMenu(menu);
        menuRepository.save(menuRole);

        Menu menuMenu = new Menu();
        menuMenu.setMenuAdi("Menu Tanım");
        menuMenu.setMenuIndex(3);
        menuMenu.setIcon("");
        menuMenu.setModule("tanimlar");
        menuMenu.setParentMenu(menu);
        menuRepository.save(menuMenu);

        Menu menuPersonel = new Menu();
        menuPersonel.setMenuAdi("Personel Tanım");
        menuPersonel.setMenuIndex(4);
        menuPersonel.setIcon("");
        menuPersonel.setModule("tanimlar");
        menuPersonel.setParentMenu(menu);
        menuRepository.save(menuPersonel);

        Permission permission = new Permission();
        permission.setMenu(menu);
        permission.setPermissionAdi("tani permission");
        permission.setRole(role);
        permission.setUser(user);
        permissionRepository.save(permission);

    }
}
