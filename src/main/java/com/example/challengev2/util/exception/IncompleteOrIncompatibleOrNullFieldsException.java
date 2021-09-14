package com.example.challengev2.util.exception;

public class IncompleteOrIncompatibleOrNullFieldsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public IncompleteOrIncompatibleOrNullFieldsException() {
    }

    public IncompleteOrIncompatibleOrNullFieldsException(String errorMessage) {
        super();
        this.errorMessage=errorMessage;
    }



}
