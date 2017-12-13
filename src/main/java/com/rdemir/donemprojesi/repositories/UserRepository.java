package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.UserImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserImp, Long> {
    UserImp findByUsername(String username);
}
