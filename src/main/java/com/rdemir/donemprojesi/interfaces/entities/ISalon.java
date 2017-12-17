package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.CihazImp;

import java.util.List;

public interface ISalon {
     String getSalonKodu();

     String getSalonAdi();

     List<CihazImp> getCihaz();
}
