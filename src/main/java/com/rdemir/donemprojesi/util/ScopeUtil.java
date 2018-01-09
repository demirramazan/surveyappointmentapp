package com.rdemir.donemprojesi.util;

public enum ScopeUtil {
    VIEW("view"), SESSION("session"), APPLICATION("application");

    private String scopeName;

    ScopeUtil(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }
}
