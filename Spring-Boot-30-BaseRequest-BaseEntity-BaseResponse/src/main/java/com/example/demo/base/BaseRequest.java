package com.example.demo.base;

import lombok.Data;

import java.util.Collection;


@Data
public class BaseRequest<T> {
    private T body;
    private String requestId;
    private String source;
}

