package com.team08.enjoytrip.auth.exception;

import com.team08.enjoytrip.common.exception.UnauthorizedException;

public class InvalidTokenException extends UnauthorizedException {
    public InvalidTokenException(String reason) {
        super(reason);
    }
}
