package com.rdemir.donemprojesi.util;

public enum RoleType {
    ADMIN("Admin"), DOKTOR("Doktor"), TEKNISYEN("Teknisyen"), UZMAN("Uzman"), SEKRETER("Sekreter");

    String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
