package com.rdemir.donemprojesi.config;

import com.rdemir.donemprojesi.util.KanGrubu;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@FacesConverter(value = "kanGrubuConverter")
public class KanGrubuConventer extends EnumConverter {
    public KanGrubuConventer() {
        super(KanGrubu.class);
    }
}
