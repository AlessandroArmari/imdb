package com.demo.imdb.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ResponseEntity<CustomError> handle(RuntimeException ex) {
        return ResponseEntity.internalServerError().build();
    }
}
}
