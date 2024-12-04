package com.demo.imdb.constant;

import com.demo.imdb.util.ErrorMessageBuilder;

import java.util.Map;

import static java.util.Map.entry;

public class ExceptionConstants {

    public static String RUN_TIME_EXCEPTION = "RuntimeException";
    public static String NOT_FOUND_EXCEPTION = "NotFoundException";
    public static String MAPPING_EXCEPTION = "MappingException";


    public static Map<String, Integer> mapExToStackTraceIndex = Map.ofEntries(
            entry(RUN_TIME_EXCEPTION, 2),
            entry(NOT_FOUND_EXCEPTION, 1),
            entry(MAPPING_EXCEPTION, 4)
    );




}
