package com.solvd.ITCompany.utils.enums;

public enum JobType {
    FRONTEND(1),
    BACKEND(2),
    DESIGNER(3),
    QA(4);

    private int code;
    JobType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
