package com.sqa.thermometer.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class JPAException extends ResponseEntityExceptionHandler {

    public JPAException(String message){
        this.setMessageSource(getMessageSource());
    }
}