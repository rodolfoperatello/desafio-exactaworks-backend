package br.com.exactaworks.desafio.exceptions.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
