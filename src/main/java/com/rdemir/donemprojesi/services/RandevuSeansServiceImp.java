package com.rdemir.donemprojesi.services;

import com.rdemir.donemprojesi.entities.RandevuSablon;
import com.rdemir.donemprojesi.entities.RandevuSeans;
import com.rdemir.donemprojesi.services.interfaces.IRandevuSeansService;
import com.rdemir.donemprojesi.repositories.RandevuSeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandevuSeansServiceImp implements IRandevuSeansService<RandevuSeans> {

    @Autowired
    private RandevuSeansRepository seansRepository;

    @Override
    public List<RandevuSeans> findAll() {
        return seansRepository.findAll();
    }

    @Override
    public RandevuSeans findOne(Long id) {
        return seansRepository.getOne(id);
    }

    @Override
    public void save(RandevuSeans randevuSeans) {
        boolean flag = true;

        if (randevuSeans.getRandevuSablon() != null) {
            RandevuSablon sablon = randevuSeans.getRandevuSablon();
            List<RandevuSeans> seansList = new ArrayList<>();

            Float saatBaslangic = Float.valueOf(sablon.getSaatBaslangic().replace(":", "."));
            Float saatBitis = Float.valueOf(sablon.getSaatBitis().replace(":", "."));
            Float ogleArasiBaslangic = Float.valueOf(sablon.getSaatOglenBaslangic().replace(":", "."));
            Float ogleArasiBitis = Float.valueOf(sablon.getSaatOglenBitis().replace(":", "."));
            Float randevuSuresi = Float.valueOf(sablon.getRandevuSuresi()) / 100;

            Float seansBitis, dakika;
            int sirano = 0;
            Float i = saatBaslangic;
            while (i < saatBitis) {
                i = Float.valueOf(String.format("%.2f", i).replace(",", "."));
                dakika = Float.valueOf(String.format("%.2f", i % 1).replace(",", "."));
                if (dakika >= .6f) {
                    i = i - dakika;
                    i += Float.valueOf(String.format("%.2f", dakika / .6f).replace(",", ".")).intValue();
                    i += Float.valueOf(String.format("%.2f", dakika % .6f).replace(",", "."));
                }

                seansBitis = i - dakika;
                seansBitis += Float.valueOf(String.format("%f", (dakika + randevuSuresi) / .6f).replace(",", ".")).intValue();
                seansBitis += Float.valueOf(String.format("%f", (dakika + randevuSuresi) % .6f).replace(",", "."));

                if ((i < ogleArasiBaslangic && seansBitis <= ogleArasiBitis) || (i >= ogleArasiBitis && seansBitis >= ogleArasiBitis) && seansBitis <= saatBitis) {
                    RandevuSeans seans = randevuSeans;
                    seans.setSaatBaslangic(String.format("%.2f", i).replace(",", ":"));
                    seans.setSaatBitis(String.valueOf(String.format("%.2f", seansBitis)).replace(",", ":"));
                    seans.setSiraNo(++sirano);
                    seansRepository.save(seans);

                    seansList.add(seans);

                }

                i = Float.valueOf(String.format("%.2f", seansBitis).replace(",", "."));

                if (i >= ogleArasiBaslangic && flag) {
                    flag = false;
                    i = ogleArasiBitis;
                }

            }
            seansRepository.save(randevuSeans);
        }
    }

    @Override
    public void delete(Long id) {
        seansRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        seansRepository.deleteAll();
    }
}
