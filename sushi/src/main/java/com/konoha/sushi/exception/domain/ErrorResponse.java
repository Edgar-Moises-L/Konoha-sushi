package com.konoha.sushi.exception.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@JsonRootName("error")
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;

    public ErrorResponse(Exception e, int status,String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = e.getMessage();
        this.path = path;
    }
}
