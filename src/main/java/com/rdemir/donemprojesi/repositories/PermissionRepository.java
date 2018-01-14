package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findByRole(Role role);

    List<Permission> findByUser(User user);

    Permission findByMenu(Menu menu);

    List<Permission> findByRoleAndMenu(Role role, Menu menu);

    List<Permission> findByUserAndRole(User user, Role role);

}