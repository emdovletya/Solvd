package com.solvd.ITCompany.utils.exceptions;

public class NotNullException extends RuntimeException {
    public NotNullException() {
        super("Should not be null");
    }
}
