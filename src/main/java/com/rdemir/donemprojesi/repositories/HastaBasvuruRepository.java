package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.HastaBasvuru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaBasvuruRepository extends JpaRepository<HastaBasvuru, Long> {
    @Query("SELECT coalesce(max(hb.basvuruNo), 1) FROM HastaBasvuru hb")
    Integer getMaxBasvuruNo();
}
