package br.com.exactaworks.desafio.exceptions.handler;

import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import br.com.exactaworks.desafio.exceptions.exceptiondetails.NotFoundExceptionDetails;
import br.com.exactaworks.desafio.exceptions.exceptiondetails.MethodArgumentNotValidExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    private final Logger logger = Logger.getLogger("br.com.exactaworks.desafio.exceptions.exceptiondetails");

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundExceptionDetails handleNotFoundException(NotFoundException notFoundException){
        return new NotFoundExceptionDetails("Not Found Exception", HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<MethodArgumentNotValidExceptionDetails> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException){

        return methodArgumentNotValidException
                .getFieldErrors()
                .stream()
                .map(fieldError -> new MethodArgumentNotValidExceptionDetails(
                        fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
    }
}
