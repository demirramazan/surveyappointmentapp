package com.rdemir.donemprojesi.util;

public enum KanGrubu {
    O_RH_NEGATIF("O Rh -"),
    O_RH_POZITIF("O Rh +"),
    A_RH_NEGATIF("A Rh -"),
    A_RH_POZITIF("A Rh +"),
    B_RH_NEGATIF("A Rh -"),
    B_RH_POZITIF("B Rh +"),
    AB_RH_NEGATIF("AB Rh -"),
    AB_RH_POZITIF("AB Rh +");

    String name;

    KanGrubu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
