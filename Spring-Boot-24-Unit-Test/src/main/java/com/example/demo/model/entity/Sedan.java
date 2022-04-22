package com.example.demo.model.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Sedan implements Car{
    public static final String carType = "Sedan";

    @Override
    public String getType() {
        return carType;
    }

}
