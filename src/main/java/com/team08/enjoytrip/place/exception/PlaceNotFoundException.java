package com.team08.enjoytrip.place.exception;

import com.team08.enjoytrip.common.exception.EnjoyTripApiException;
import org.springframework.http.HttpStatus;

public class PlaceNotFoundException extends EnjoyTripApiException {
    public PlaceNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
