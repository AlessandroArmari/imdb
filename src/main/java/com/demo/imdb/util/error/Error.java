package com.demo.imdb.util.error;

import com.demo.imdb.constant.UtilConstants;
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



    /*
    //MappingException
    public Error(MappingException mappingException) {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = mappingException.getMessage();
        this.consoleMessage = mappingException.getLocalizedMessage();
        this.user = UTENTE_DA_DEFINIRE;
        this.declaringClass = mappingException.getStackTrace()[4].getClassName();
        this.method = mappingException.getStackTrace()[4].getMethodName();
        this.lineNumber = mappingException.getStackTrace()[4].getLineNumber();
        this.timestamp = Instant.now();
    }

    //notFoundException
    public Error(NotFoundException notFoundException) {
        this.status = HttpStatus.NO_CONTENT;
        this.message = notFoundException.getMessage();
        this.consoleMessage = notFoundException.getLocalizedMessage();
        this.user = UTENTE_DA_DEFINIRE;
        this.declaringClass = notFoundException.getStackTrace()[1].getClassName();
        this.method = notFoundException.getStackTrace()[1].getMethodName();
        this.lineNumber = notFoundException.getStackTrace()[1].getLineNumber();
        this.timestamp = Instant.now();
    }
     */

    public static Error errorBuilder(Exception ex) {

        System.out.println(ex.getClass().getSimpleName());
        return Error.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Not handled exception")
                .consoleMessage(ex.getLocalizedMessage())
                .user(UtilConstants.UTENTE_DA_DEFINIRE)
                .declaringClass(ex.getStackTrace()[UtilConstants.mapExToStackTraceIndex.getOrDefault(ex.getClass().getSimpleName(), 0)].getClassName())
                .method(ex.getStackTrace()[UtilConstants.mapExToStackTraceIndex.getOrDefault(ex.getClass().getSimpleName(), 0)].getMethodName())
                .lineNumber(ex.getStackTrace()[UtilConstants.mapExToStackTraceIndex.getOrDefault(ex.getClass().getSimpleName(), 0)].getLineNumber())
                .timestamp(Instant.now())
                .build();

    }


}


