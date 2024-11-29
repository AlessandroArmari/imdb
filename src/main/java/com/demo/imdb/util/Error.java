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
    private Instant timestamp;

    public Error(Exception ex) {

        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = ex.getMessage();
        this.consoleMessage = ex.getLocalizedMessage();
        this.user = "utente da definire";
        this.timestamp = Instant.now();

    }
}


