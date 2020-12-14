package br.com.exactaworks.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GenericExceptionHandler extends RuntimeException{

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GenericException.class)
    public ErrorResponse handleGenericException(GenericException genericException){
        return new ErrorResponse(genericException.getMessage());
    }
}
