package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.RoleImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReporsitory extends JpaRepository<RoleImp, Long> {
}
