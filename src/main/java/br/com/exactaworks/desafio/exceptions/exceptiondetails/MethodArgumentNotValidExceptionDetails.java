package br.com.exactaworks.desafio.exceptions.exceptiondetails;

public class methodArgumentNotValidExceptionDetails {

    private final String attribute;
    private final String message;

    public methodArgumentNotValidExceptionDetails(String attribute, String message) {
        this.attribute = attribute;
        this.message = message;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getMessage() {
        return message;
    }
}
