package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.scope.ScopeName;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.List;

@Component("userBean")
@Scope(ScopeName.SESSION)
public class UserController {

    @Autowired
    private IUserService userService;

    private User user;
    private User selectedUser;
    private List<User> userList;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Boolean enabled;
    private Role role;

    @PostConstruct
    public void init() {
        userList = userService.getAllUsers();
    }

    public UserController() {
        user = new User(username, password, name, surname, enabled, role, null);
    }

    public User findById(Long id) {
        return userService.getUserById(id);
    }

    public User save() {
        return userService.save(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void onRowSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, null);
    }

}
