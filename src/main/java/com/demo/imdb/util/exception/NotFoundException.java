package com.demo.imdb.util.exception;

import lombok.*;

import java.io.Serial;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException (String message) {
        this.message = message;
    }

}
