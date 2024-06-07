package com.exceptions;

public class DuplicatedException extends RuntimeException {
    public DuplicatedException(String mensaje) {
        super(mensaje);
    }
}
