package com.konoha.sushi.exception.infrastructure;

import com.konoha.sushi.exception.domain.ErrorResponse;
import com.konoha.sushi.exception.domain.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ApiExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildResponse(e, HttpStatus.NOT_FOUND,request));
    }

    public ErrorResponse buildResponse(Exception e, HttpStatus httpStatus, HttpServletRequest request) {
        return new ErrorResponse(e, httpStatus.value(), request.getRequestURI());
    }
}
