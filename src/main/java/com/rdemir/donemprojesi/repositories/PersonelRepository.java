package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonelRepository extends JpaRepository<Personel, Long> {
//    @Query("SELECT p FROM Personel p where p.birim_id=?1")
//    List<Personel> findAllByBirim_Id(Long birimId);
}
