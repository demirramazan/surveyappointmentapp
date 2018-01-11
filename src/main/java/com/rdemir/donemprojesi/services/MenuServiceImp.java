package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.interfaces.services.IMenuService;
import com.rdemir.donemprojesi.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements IMenuService<Menu> {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenu(Long id) {
        return menuRepository.getOne(id);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.saveAndFlush(menu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.delete(id);
    }
}
