package org.example.traodoisub.exception;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    int getCode();

    String getMessage();

    HttpStatus getHttpStatus();
}

