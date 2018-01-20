package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import com.rdemir.donemprojesi.interfaces.services.IPermissionService;
import com.rdemir.donemprojesi.interfaces.services.IRoleService;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("permission")
@Scope(ScopeName.REQUEST)
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    private Permission permission;
    private Permission selectedPermission;
    private List<Permission> permissionList;
    private Menu menu;
    private Role role;
    private User user;
    private List<Menu> menuList;
    private List<Role> roleList;
    private List<User> userList;

    public PermissionController() {
        permission = new Permission();
        menu = new Menu();
        role = new Role();
        user = new User();
    }

    @PostConstruct
    public void init() {
        permissionList = permissionService.getPermissions();
        menuList = menuService.getMenus();
        userList = userService.getAllUsers();
        roleList = roleService.getRoles();
    }

    public void save() {
        permission.setUser(user);
        permission.setRole(role);
        permission.setMenu(menu);
        permissionService.save(permission);
    }

    public void delete() {
        permissionService.delete(permission.getId());
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Permission getSelectedPermission() {
        return selectedPermission;
    }

    public void setSelectedPermission(Permission selectedPermission) {
        this.selectedPermission = selectedPermission;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void onDcRowSelect(SelectEvent event) {
        selectedPermission = (Permission) event.getObject();
        this.permission = selectedPermission;
    }
}
