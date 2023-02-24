package com.travelex.resolucao.exceptions.handler;

import com.travelex.resolucao.exceptions.BadRequestException;
import com.travelex.resolucao.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {
    private static final String PATTERN= "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN);
    private final String CUSTOM_MESSAGE_BAD_REQUEST = "Favor verificar os parametros inseridos";
    private final String CUSTOM_MESSAGE_GENERIC_EXCEPTION = "Ocorreu um erro inesperado em nosso servidor!";


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericExceptions(Exception ex, WebRequest webRequest) {
       ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now().format(dateTimeFormatter), CUSTOM_MESSAGE_GENERIC_EXCEPTION, ex.getMessage(), webRequest.getDescription(false));
       return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now().format(dateTimeFormatter), CUSTOM_MESSAGE_BAD_REQUEST, ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
