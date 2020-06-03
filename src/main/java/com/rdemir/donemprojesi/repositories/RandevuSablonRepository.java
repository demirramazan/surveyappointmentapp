package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.RandevuSablon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandevuSablonRepository extends JpaRepository<RandevuSablon,Long> {
}
