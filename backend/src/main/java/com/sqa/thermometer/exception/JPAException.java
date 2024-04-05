package com.sqa.thermometer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class JPAException extends ResponseEntityExceptionHandler {

    public JPAException(String message){
    //public ResponseEntity<String> handleJpaSystemException(JpaSystemException ex) {
        this.setMessageSource(getMessageSource());
}
}