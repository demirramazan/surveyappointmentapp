package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Cihaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CihazRepository extends JpaRepository<Cihaz, Long> {
}
