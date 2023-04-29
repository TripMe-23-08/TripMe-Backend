package com.team08.enjoytrip.common.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {
    private LocalDateTime timeStamp; // yyyy-MM-dd HH:mm:ss
    private int status;
    private String path;
    private String remote;
}
