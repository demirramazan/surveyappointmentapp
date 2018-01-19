package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.HastaTetkikRapor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TetkikRaporRepository extends JpaRepository<HastaTetkikRapor,Long> {
}
