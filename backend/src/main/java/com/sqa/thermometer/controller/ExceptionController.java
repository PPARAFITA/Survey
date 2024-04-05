package com.sqa.thermometer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sqa.thermometer.exception.JPAException;
import com.sqa.thermometer.exception.ThermometerException;

@ControllerAdvice
public class ExceptionController  extends ResponseEntityExceptionHandler {
    
    // @ExceptionHandler(ThermometerException.class)
    // public ResponseEntity<String> handleException(ThermometerException ex) {
    //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    // }

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<String> handleJpaSystemException(JpaSystemException ex) {
        // Maneja la excepción y devuelve una respuesta adecuada al cliente
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error en la base de datos");
    }
}