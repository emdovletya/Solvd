package com.solvd.ITCompany.utils.exceptions;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException() {
        super("String cannot be empty!");
    }
}
