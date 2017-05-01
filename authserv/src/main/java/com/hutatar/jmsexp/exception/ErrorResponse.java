package com.hutatar.jmsexp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final LocalDateTime timeStamp;
    private final String message;
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public ErrorResponse(String message, ErrorCode errorCode, HttpStatus httpStatus) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public static ErrorResponse of(String message, ErrorCode errorCode, HttpStatus httpStatus) {
        return new ErrorResponse(message, errorCode, httpStatus);
    }

}
