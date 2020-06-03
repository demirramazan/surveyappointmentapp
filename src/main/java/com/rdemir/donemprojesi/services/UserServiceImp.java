package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.User;
import com.rdemir.donemprojesi.interfaces.services.IUserService;
import com.rdemir.donemprojesi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImp implements IUserService<User> {

    @Autowired
    private UserRepository userRepository;
   /* @Inject
    private Se*//*ssionInitializer sessionInitializer;*/

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User userImp) {
        return userRepository.save(userImp);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User login(String username, String password, HttpSession httpSession) {
        try {
            if ("".equals(username) || username == null) {
                throw new RuntimeException("Kullanıcı adı boş beçilemez!");
            }

            if ("".equals(password) || password == null) {
                throw new RuntimeException("Şifre boş beçilemez!");
            }

            User user = getUserByUsernameAndPassword(username, password);
            if (user != null) {

                // Session timeout burada ayarlanıyor saniye cinsinden (60 * 60 = 60 dakika demek)
                httpSession.setMaxInactiveInterval(60 * 60);

              /*  // Kullanıcı session bazında bilgileri SessionInitializer a yüklüyoruz
                sessionInitializer.setHttpSession(httpSession);
                sessionInitializer.setUser(user);*/


                httpSession.setAttribute("user", user);


                return user;
            } else {
                throw new RuntimeException("Kullanıcı adı veya şifreniz hatalı!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
