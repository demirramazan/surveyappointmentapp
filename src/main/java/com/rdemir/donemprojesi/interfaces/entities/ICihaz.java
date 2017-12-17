package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.SalonImp;

public interface ICihaz {

    String getKodu();

    String getAdi();

    Integer getAktifMi();

    SalonImp getSalon();
}
