package br.com.exactaworks.desafio.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private final String errorMessage;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
