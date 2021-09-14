package com.example.challengev2.util.exception;

public class VoidParameterException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public VoidParameterException(String errorMessage) {
        super();
        this.errorMessage=errorMessage;
    }

    public VoidParameterException() {
    }
}
