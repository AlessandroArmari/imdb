package com.demo.imdb.configuration;

import com.demo.imdb.util.error.Error;
import com.demo.imdb.util.exception.NotFoundException;
import org.modelmapper.MappingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //SEI QUI
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        return new ResponseEntity<>(null, status);
    }


    @ExceptionHandler(value = {MappingException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Error> handleMappingEx(MappingException mappingException) {
        Error error = Error.errorBuilder(mappingException);
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Error> handleNotFoundEx(NotFoundException notFoundException) {
        Error error = Error.errorBuilder(notFoundException);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Error> handleUnHandledRunTimeEx(RuntimeException unHandledRunTimeException) {
        Error error = Error.errorBuilder(unHandledRunTimeException);
        return ResponseEntity.internalServerError().body(error);
    }



}

