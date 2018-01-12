//package com.rdemir.donemprojesi.interfaces.services;
//
//import com.rdemir.donemprojesi.entities.SessionUserImp;
//import com.rdemir.donemprojesi.entities.User;
//import com.rdemir.donemprojesi.interfaces.SessionUser;
//import com.rdemir.donemprojesi.services.UserServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.InternalAuthenticationServiceException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
//    @Autowired
//    private UserServiceImp userService;
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        if (authentication.getPrincipal() instanceof SessionUser) { // if user already logged in
//            return authentication;
//        } else {
//            String userName = (String) authentication.getPrincipal(); // username
//            String password = (String) authentication.getCredentials(); // password
//
//            User user = userService.getUserByUsernameAndPassword(userName, password); // match user using username and password
//
//            if (user != null) {
//                SessionUserImp currentUser = new SessionUserImp(user);// create current user data using user entity
//                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(currentUser, password, currentUser.getAuthorities()); // create token for logged in user
//                return token;
//            } else { // user is not present
//                throw new InternalAuthenticationServiceException("Invalid Username or Password");
//            }
//        }
//    }
//}
