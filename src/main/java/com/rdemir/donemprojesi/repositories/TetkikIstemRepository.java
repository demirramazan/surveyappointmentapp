package com.rdemir.donemprojesi.repositories;

import com.rdemir.donemprojesi.entities.HastaTetkikIstem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TetkikIstemRepository extends JpaRepository<HastaTetkikIstem,Long>{
}
