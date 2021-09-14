package com.example.challengev2.util.exception;

public class TheCharacterDoesNotExistException extends RuntimeException {

    public TheCharacterDoesNotExistException() {
    }
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TheCharacterDoesNotExistException(String errorMessage) {
        super();
        this.errorMessage=errorMessage;
    }
}
