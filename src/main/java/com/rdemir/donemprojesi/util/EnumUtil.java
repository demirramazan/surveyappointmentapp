package com.rdemir.donemprojesi.util;

public class EnumUtil {

    enum Cinsiyet {
        ERKEK(1, "Erkek"),
        KADIN(2, "Kadın"),
        BELIRSIZ(3, "Belirsiz");

        private int kodu;
        private String adi;

        Cinsiyet(int kodu, String adi) {
            this.kodu = kodu;
            this.adi = adi;
        }

        public int getKodu() {
            return kodu;
        }

        public String getAdi() {
            return adi;
        }
    }
}
