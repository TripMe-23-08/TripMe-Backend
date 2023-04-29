package com.team08.enjoytrip.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponseDto<T> {
    private String message;
    private T data;
}
