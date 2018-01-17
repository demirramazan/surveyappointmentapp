package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Birim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirimRepository extends JpaRepository<Birim, Long> {
}
