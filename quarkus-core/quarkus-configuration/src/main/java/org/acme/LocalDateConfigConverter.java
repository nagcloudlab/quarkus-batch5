package org.acme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.eclipse.microprofile.config.spi.Converter;


public class LocalDateConfigConverter implements Converter<LocalDate>{
    @Override
    public LocalDate convert(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        return LocalDate.parse(value,formatter);
    }
}