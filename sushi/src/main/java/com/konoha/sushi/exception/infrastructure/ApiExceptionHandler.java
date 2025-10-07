package com.konoha.sushi.exception.infrastructure;

import com.konoha.sushi.exception.domain.ErrorResponse;
import com.konoha.sushi.exception.domain.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildResponse(e, HttpStatus.NOT_FOUND,request));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handlerIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buildResponse(e,HttpStatus.BAD_REQUEST, request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException e) {

        String errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(new Exception(errors), HttpStatus.BAD_REQUEST.value(), request.getRequestURI()));
    }

    public ErrorResponse buildResponse(Exception e, HttpStatus httpStatus, HttpServletRequest request) {
        return new ErrorResponse(e, httpStatus.value(), request.getRequestURI());
    }
}
