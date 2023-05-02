package com.team08.enjoytrip.post.exception;

import com.team08.enjoytrip.common.exception.EnjoyTripApiException;
import org.springframework.http.HttpStatus;

public class ArticleNotFoundException extends EnjoyTripApiException {
    public ArticleNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
