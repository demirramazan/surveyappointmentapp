package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByMenuAdi(String menuAdi);

    Optional<Menu> findAllByParentMenuOrderByMenuIndexAsc(Menu parentMenu);

}
