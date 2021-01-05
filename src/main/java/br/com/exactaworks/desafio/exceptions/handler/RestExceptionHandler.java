package br.com.exactaworks.desafio.exceptions.handler;

import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import br.com.exactaworks.desafio.exceptions.exceptiondetails.GenericExceptionDetails;
import br.com.exactaworks.desafio.exceptions.exceptiondetails.MethodArgumentNotValidExceptionDetails;
import br.com.exactaworks.desafio.exceptions.exceptiondetails.NotFoundExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    private final Logger logger = Logger.getLogger("br.com.exactaworks.desafio.exceptions.exceptiondetails");

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handleNotFoundException(NotFoundException notFoundException){
        var notFoundExceptionDetails = new NotFoundExceptionDetails(
                "Not Found Exception", HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());

        return new ResponseEntity<>(notFoundExceptionDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var errorList = exception
                .getFieldErrors()
                .stream()
                .map(fieldError -> new MethodArgumentNotValidExceptionDetails(
                        fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

        return new ResponseEntity<>(errorList, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var exceptionDetails = new GenericExceptionDetails(ex.getCause().getMessage(), status.value(), ex.getMessage());
        return new ResponseEntity<>(exceptionDetails, headers, status);
    }
}
