package com.Mizan.MizanApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    If we don't use the api error handling then the default error response will be like this
//    @ExceptionHandler(PollNotFoundException.class)
//    public ResponseEntity<Map<String , String>> handlePollNotFoundException(PollNotFoundException ex) {
//        Map<String ,String> errorResponse=new HashMap<>();
//        errorResponse.put("error", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
    @ExceptionHandler(PollNotFoundException.class)
    public ResponseEntity<ApiError> handlePollNotFoundException(PollNotFoundException ex){
        ApiError apiError=new ApiError(
                "POLL_NOT_FOUND",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                java.time.LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex){
//        Map<String,String> errorResponse=new HashMap<>();
//        errorResponse.put("error", "An unexpected error occurred: " + ex.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
    public ResponseEntity<ApiError>handleGeneralException(Exception ex){
        ApiError apiError=new ApiError(
                "INTERNAL_SERVER_ERROR",
                "An unexpected error occurred: " +ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                java.time.LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
