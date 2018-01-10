package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByMenuAdi(String menuAdi);
}
