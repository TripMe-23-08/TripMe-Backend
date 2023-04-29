package com.team08.enjoytrip.common.dto;

public class ErrorResponseDto extends ResponseDto<ErrorDetail> {
    public ErrorResponseDto(String message, ErrorDetail data) {
        super(message, data);
    }
}
