package com.Mizan.MizanApp.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {
    private String code;
    private String message;
    private int status;
    private LocalDateTime timestamp;

    public ApiError(String code, String message,int status,LocalDateTime timestamp){
        this.code=code;
        this.message=message;
        this.status=status;
        this.timestamp=timestamp;
    }
}
