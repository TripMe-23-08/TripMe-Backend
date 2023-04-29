package com.team08.enjoytrip.user.exception;

import com.team08.enjoytrip.common.exception.EnjoyTripApiException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends EnjoyTripApiException {
    public UserNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
