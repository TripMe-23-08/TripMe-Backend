package com.team08.enjoytrip.user.exception;

import com.team08.enjoytrip.common.exception.EnjoyTripApiException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends EnjoyTripApiException {
    public UserAlreadyExistException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
