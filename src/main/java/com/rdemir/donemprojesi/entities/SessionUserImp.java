//package com.rdemir.donemprojesi.entities;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.rdemir.donemprojesi.interfaces.SessionUser;
//import org.springframework.security.core.authority.AuthorityUtils;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class SessionUserImp extends org.springframework.security.core.userdetails.User implements SessionUser {
//
//    private User user;
//    private HashMap<String, Object> properties;
//
//
//    public SessionUserImp(User user) {
//        super(user.getUsername(), user.getPassword(),
//                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole() != null ? user.getRole().getCode() : ""));
//        this.user = user;
//    }
//
//
//    @Override
//    public User getUser() {
//        return user;
//    }
//
//    @Override
//    public Object getId() {
//        return user.getId();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public List getAuthorities() {
//        return AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole() != null ? user.getRole().getCode() : "");
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return super.isEnabled();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return super.isAccountNonLocked();
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return super.isCredentialsNonExpired();
//    }
//
//    @Override
//    public void eraseCredentials() {
//        super.eraseCredentials();
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
//    public String getName() {
//        return user.getName();
//    }
//
//    @Override
//    public String getSurname() {
//        return user.getSurname();
//    }
//
//    @Override
//    public HashMap<String, Object> getProperties() {
//        return properties;
//    }
//
//    public void setProperties(HashMap<String, Object> properties) {
//        this.properties = properties;
//    }
//
//
//}
//
