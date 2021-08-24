package com.solvd.ITCompany.utils.enums;

public enum Seniority {
    JUNIOR(1),
    MIDDLE(2),
    SENIOR(3);

    private int code;
    Seniority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
