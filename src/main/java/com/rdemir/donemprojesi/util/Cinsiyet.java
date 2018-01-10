package com.rdemir.donemprojesi.util;

public enum Cinsiyet {
    ERKEK(1, "Erkek"),
    KADIN(2, "Kadın"),
    BELIRSIZ(3, "Belirsiz");

    private Integer kodu;
    private String adi;

    Cinsiyet(int kodu, String adi) {
        this.kodu = kodu;
        this.adi = adi;
    }

    public Integer getKodu() {
        return kodu;
    }

    public void setKodu(Integer kodu) {
        this.kodu = kodu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

//    public static EnumUtil.Cinsiyet parse(Integer kodu) {
//
//        EnumUtil.Cinsiyet cinsiyet = null;
//
//        for (EnumUtil.Cinsiyet cinsiyet1 : EnumUtil.Cinsiyet.values()) {
//            if ((cinsiyet1.getKodu().equals(kodu))) {
//                cinsiyet = cinsiyet1;
//            }
//        }
//
//        return cinsiyet;
//    }

}