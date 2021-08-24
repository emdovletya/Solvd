package com.solvd.ITCompany.utils.enums;

public enum Complexity {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private int code;

    Complexity(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
