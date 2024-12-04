package com.demo.imdb.util;

public class ErrorMessageBuilder {

    public static String notFoundById(Class<?> className, Long id) {
        return String.format("%s (id: %s) not found in db", className.getSimpleName(), id);
    }
}
