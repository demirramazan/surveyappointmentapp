package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.RandevuSeans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandevuSeansRepository extends JpaRepository<RandevuSeans,Long> {
}
