package com.demo.imdb.configuration;

import com.demo.imdb.util.Error;
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
    public ResponseEntity<Error> handleRunTimeEx(RuntimeException ex) {

        Error error = new Error(ex);
        return ResponseEntity.internalServerError().body(error);
    }

}

