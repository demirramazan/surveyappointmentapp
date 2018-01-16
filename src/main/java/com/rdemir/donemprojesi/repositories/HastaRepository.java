package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaRepository extends JpaRepository<Hasta, Long> {
}
