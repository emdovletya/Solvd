package com.solvd.ITCompany.utils.exceptions;

public class NotNegativeNumberException extends RuntimeException {
    public NotNegativeNumberException() {
        super("Cannot be negative!");
    }
}
