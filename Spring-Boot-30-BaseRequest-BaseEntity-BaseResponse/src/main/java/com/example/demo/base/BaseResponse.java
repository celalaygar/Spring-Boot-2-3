package com.example.demo.base;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Collection;

@Data
public class BaseResponse<T> {

    private boolean success;
    private String resultCode;
    private HttpStatus httpStatus;
    private Integer statusCode;
    private Collection<T> data;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, String resultCode, HttpStatus httpStatus, Collection<T> data) {
        this.success = success;
        this.resultCode = resultCode;
        this.httpStatus = httpStatus;
        this.statusCode = httpStatus.value();
        this.data = data;
    }

}
