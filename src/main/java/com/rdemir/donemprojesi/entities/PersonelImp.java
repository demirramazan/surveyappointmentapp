package com.rdemir.donemprojesi.entities;

import com.rdemir.donemprojesi.util.EnumUtil;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSONEL")
public class PersonelImp extends BaseEntity {

    @Column(name = "PERSONEL_ADI", nullable = false, length = 50)
    private String personelAdi;

    @Column(name = "PERSONEL_SOYADI", nullable = false, length = 50)
    private String personelSoyadi;

    @Column(name = "KIMLIK_NO")
    @Size(max = 11)
    private String kimlikNo;

    @Email(regexp = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\\\\\.[A-Z]{2,6}", message = "Email hatali")
    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "TELEFON_NO")
    @Max(10)
    private Integer telefonNo;

    @Column(name = "ADRES", length = 500)
    private String adres;

//    @Enumerated(EnumType.ORDINAL)
    @Column(name = "CINSIYET", nullable = false)
    private Integer cinsyet;

    public PersonelImp(String personelAdi, String personelSoyadi, String kimlikNo, String email, Integer telefonNo, String adres) {
        this.personelAdi = personelAdi;
        this.personelSoyadi = personelSoyadi;
        this.kimlikNo = kimlikNo;
        this.email = email;
        this.telefonNo = telefonNo;
        this.adres = adres;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    public String getPersonelSoyadi() {
        return personelSoyadi;
    }

    public void setPersonelSoyadi(String personelSoyadi) {
        this.personelSoyadi = personelSoyadi;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(Integer telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Integer getCinsyet() {
        return 0;
    }

    public void setCinsyet(Integer cinsyet) {
        this.cinsyet = cinsyet;
    }
}
