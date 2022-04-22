    package com.example.demo.service;


import com.example.demo.model.entity.Car;
import com.example.demo.factory.CarFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    public final CarFactory carFactory;

    public String getCarType(String type){
        Car car = carFactory.createCarFactory(type);
        return car != null ? car.getType()+car.defaultValue : null;
    }
}
