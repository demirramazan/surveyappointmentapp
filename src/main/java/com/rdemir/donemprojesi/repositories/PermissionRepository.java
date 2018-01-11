package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Menu;
import com.rdemir.donemprojesi.entities.Permission;
import com.rdemir.donemprojesi.entities.Role;
import com.rdemir.donemprojesi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByRole(Role role);

    Permission findByUser(User user);

    Permission findByMenu(Menu menu);

    Permission findByRoleAndMenu(Role role, Menu menu);
}
