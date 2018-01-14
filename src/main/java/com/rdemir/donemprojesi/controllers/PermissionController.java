package com.rdemir.donemprojesi.controllers;

import com.rdemir.donemprojesi.scope.ScopeName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("permission")
@Scope(ScopeName.REQUEST)
public class PermissionController {
}
