package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<Personel, Long> {
}
