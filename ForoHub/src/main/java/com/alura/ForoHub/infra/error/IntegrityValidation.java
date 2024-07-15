package com.alura.ForoHub.infra.error;

public class IntegrityValidation extends RuntimeException{
    public IntegrityValidation(String s) {
        super(s);
    }
}
