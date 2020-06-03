package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Tetkik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TetkikRepository extends JpaRepository<Tetkik, Long> {
    List<Tetkik> findAllByAktifMi(Boolean aktifMi);
}
