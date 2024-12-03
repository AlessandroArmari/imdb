package com.demo.imdb.constant;

import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.util.Map.entry;

public class UtilConstants {

    public static DateTimeFormatter formatterEU = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static DateTimeFormatter formatterUSA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Map<String, Integer> mapExToStackTraceIndex = Map.ofEntries(entry("RuntimeException", 2), entry("NotFoundException", 1), entry("MappingException", 4));

    public static String UTENTE_DA_DEFINIRE = "utente_da_definire";

}
