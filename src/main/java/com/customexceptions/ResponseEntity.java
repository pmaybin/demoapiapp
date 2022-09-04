package com.customexceptions;

import org.springframework.http.HttpStatus;

public class ResponseEntity<S> {
    private HttpStatus status;
    private String body;

    public ResponseEntity(String message, HttpStatus status) {
        this.body = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
