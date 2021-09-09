package com.example.challengev2.controller;

import com.example.challengev2.util.IncompleteOrIncompatibleOrNullFieldsException;
import com.example.challengev2.util.TheCharacterDoesNotExistException;
import com.example.challengev2.util.VoidParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(VoidParameterException.class)
    public ResponseEntity<String> handleVoidParameter(VoidParameterException voidParameterException){
        return new ResponseEntity<>(voidParameterException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncompleteOrIncompatibleOrNullFieldsException.class)
    public ResponseEntity<String> handleIncompleteOrIncompatibleOrNullFieldsException(IncompleteOrIncompatibleOrNullFieldsException incompleteOrIncompatibleOrNullFieldsException){
        return new ResponseEntity<>(incompleteOrIncompatibleOrNullFieldsException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TheCharacterDoesNotExistException.class)
    public ResponseEntity<String> theCharacterDoesNotExistException(TheCharacterDoesNotExistException theCharacterDoesNotExistException){
        return new ResponseEntity<>(theCharacterDoesNotExistException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
    }