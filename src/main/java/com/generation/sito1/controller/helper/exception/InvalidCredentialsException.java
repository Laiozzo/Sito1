package com.generation.sito1.controller.helper.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super("Credential is invalid: " + message);
    }
}
