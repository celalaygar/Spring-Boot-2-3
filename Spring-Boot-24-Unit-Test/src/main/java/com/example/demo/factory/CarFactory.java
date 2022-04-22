package com.example.demo.factory;


import com.example.demo.model.entity.Cabrio;
import com.example.demo.model.entity.Car;
import com.example.demo.model.entity.Hatchback;
import com.example.demo.model.entity.Sedan;
import org.springframework.stereotype.Service;

@Service
public class CarFactory {


    public Car createCarFactory(String type) {
        Car car = null;

        if (Sedan.carType.equalsIgnoreCase(type)) {
            car = new Sedan();
        }else if (Cabrio.carType.equalsIgnoreCase(type)) {
            car = new Cabrio();
        }else if (Hatchback.carType.equalsIgnoreCase(type)) {
            car = new Hatchback();
        }

        return car;
    }
}
