package com.example.demo.model.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cabrio implements Car{
    public static final String carType = "Cabrio";;

    @Override
    public String getType() {
        return carType;
    }
}
