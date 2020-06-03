package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu,Long> {
}
