package com.rdemir.donemprojesi.interfaces.entities;

import com.rdemir.donemprojesi.entities.SalonImp;

public interface IBirim {

    String getBirimAdi();

    String getBirimKodu();

    String getUzunAdi();

    Integer getAktifMi();

    SalonImp getSalon();
}
