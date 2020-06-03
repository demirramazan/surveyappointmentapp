package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.HastaBasvuruDetay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaBasvuruDetayRepository extends JpaRepository<HastaBasvuruDetay, Long> {
    @Query("SELECT coalesce(max(hbd.siraNumarasi), 0) FROM HastaBasvuruDetay hbd")
    Integer getMaxSiraNumarasi();
}
