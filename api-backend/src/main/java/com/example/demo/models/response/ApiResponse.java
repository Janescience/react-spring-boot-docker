package com.example.demo.models.response;

import lombok.Data;

@Data
public class ApiResponse {

    private String message;
    private String code;
    private Object data;
    private String status;

    public ApiResponse(String message,String code,String status,Object data) {
        this.message = message;
        this.data = data;
        this.code = code;
        this.status = status;
    }
}
