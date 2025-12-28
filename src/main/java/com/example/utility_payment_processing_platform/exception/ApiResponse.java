package com.example.utility_payment_processing_platform.exception;

public class ApiResponse<T>{
    private int status;
    private String message;
    private T data;

    public ApiResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }
}
