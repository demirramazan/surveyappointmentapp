package com.rdemir.donemprojesi.util;

import java.util.HashMap;
import java.util.Map;

public class EnumUtil {

    static Map<String, Object> enumMap;

    public Map<String, Object> getEnums() {
        if (enumMap != null) {
            return enumMap;
        } else {
            enumMap = new HashMap<>();
            for (Class cls : EnumUtil.class.getClasses()) {
                String className = cls.getName();
                enumMap.put(className.substring(className.indexOf("$") + 1), cls.getEnumConstants());
            }
            return enumMap;
        }
    }

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

        public static Cinsiyet parse(Integer kodu) {

            Cinsiyet cinsiyet = null;

            for (Cinsiyet cinsiyet1 : Cinsiyet.values()) {
                if ((cinsiyet1.getKodu().equals(kodu))) {
                    cinsiyet = cinsiyet1;
                }
            }

            return cinsiyet;
        }

    }
}
