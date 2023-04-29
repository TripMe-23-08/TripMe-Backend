package com.team08.enjoytrip.common.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class EnjoyTripApiException extends ResponseStatusException {
    public EnjoyTripApiException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
