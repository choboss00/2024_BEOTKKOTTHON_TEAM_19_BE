package com.example.feelsun.config.errors.exception;

import com.example.feelsun.config.utils.ApiResponseBuilder;
import lombok.Getter;

import java.util.Map;

@Getter
public class Exception400 extends RuntimeException {
    Map<String, String> errors;

    public Exception400(Map<String, String> errors, String message) {
        super(message);
        this.errors = (errors != null) ? errors : null;
    }

    public ApiResponseBuilder.ApiResponse<?> body(){
        return ApiResponseBuilder.fail(errors, getMessage());
    }
}
