package com.example.demo.model.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Hatchback implements Car {
    public static final String carType = "Hatchback";

    @Override
    public String getType() {
        return carType;
    }
}
