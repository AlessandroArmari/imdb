package com.demo.imdb.util.error;

import com.demo.imdb.util.exception.NotFoundException;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {

    private HttpStatus status;
    private String message;
    private String consoleMessage;
    private String user;
    private String declaringClass;
    private String method;
    private Integer lineNumber;
    private Instant timestamp;

    //notFoundException
    public Error(NotFoundException notFoundException) {
        this.status = HttpStatus.NO_CONTENT;
        this.message = notFoundException.getMessage();
        this.consoleMessage = notFoundException.getLocalizedMessage();
        this.user = "utente da definire";
        this.declaringClass = notFoundException.getStackTrace()[2].getClassName();
        this.method = notFoundException.getStackTrace()[2].getMethodName();
        this.lineNumber = notFoundException.getStackTrace()[2].getLineNumber();
        this.timestamp = Instant.now();
    }

    //unHandled runTimeException
    public Error(Exception unHandledRunTimeException) {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = "Not handled exception";
        this.consoleMessage = unHandledRunTimeException.getLocalizedMessage();
        this.user = "utente da definire";
        this.declaringClass = unHandledRunTimeException.getStackTrace()[2].getClassName();
        this.method = unHandledRunTimeException.getStackTrace()[2].getMethodName();
        this.lineNumber = unHandledRunTimeException.getStackTrace()[2].getLineNumber();
        this.timestamp = Instant.now();
    }
}


