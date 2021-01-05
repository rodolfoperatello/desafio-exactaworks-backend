package br.com.exactaworks.desafio.exceptions.exceptiondetails;

import java.time.LocalDateTime;

public class GenericExceptionDetails {

    private final String title;
    private final int status;
    private final String details;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public GenericExceptionDetails(String title, int status, String details) {
        this.title = title;
        this.status = status;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
