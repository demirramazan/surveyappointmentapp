package com.rdemir.donemprojesi.config;

import com.rdemir.donemprojesi.util.Cinsiyet;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@FacesConverter(value = "cinsiyetConverter")
public class CinsiyetConventer extends EnumConverter {
    public CinsiyetConventer() {
        super(Cinsiyet.class);
    }
}
