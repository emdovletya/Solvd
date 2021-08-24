package com.solvd.ITCompany.utils.enums;

public enum Gender {
    MALE(1),
    FEMALE(2),
    EXTRA(3);

    private int code;
    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
