package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.interfaces.services.IPersonelService;
import com.rdemir.donemprojesi.util.ScopeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ScopeUtil.SESSION)
public class PersonelController {
    @Autowired
    private IPersonelService personelService;
}
