package com.geupjo.koreantiger.common.exception;

import com.geupjo.koreantiger.common.ApiResponse;
import com.geupjo.koreantiger.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ApiResponse> handleCustomExecution(CustomException e) {
        return ResponseEntity.badRequest().body(ApiResponse.createError(e.getErrorCode()));
    }

    //존재하지 않는 유저
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleNotExistUserException(CustomException e){
        return ResponseEntity.badRequest().body(ApiResponse.createError(e.getErrorCode()));
    }
}
