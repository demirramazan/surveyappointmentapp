package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.util.ScopeUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@Scope(ScopeUtil.SESSION)
public class PersonelController {
    private String deneme;

    public String getDeneme() {
        return deneme;
    }

    public void setDeneme(String deneme) {
        this.deneme = deneme;
    }
}
