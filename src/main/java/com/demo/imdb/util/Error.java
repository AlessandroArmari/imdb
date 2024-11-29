package com.demo.imdb.util;

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
    private String path;
    private Instant timestamp;

    public Error(Exception ex) {

        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = "Not handled exception";
        this.consoleMessage = ex.getLocalizedMessage();
        this.user = "utente da definire";
        this.declaringClass = ex.getStackTrace()[0].getClassName();
        this.method = ex.getStackTrace()[0].getMethodName();
        this.lineNumber = ex.getStackTrace()[0].getLineNumber();
        this.timestamp = Instant.now();

    }
}


