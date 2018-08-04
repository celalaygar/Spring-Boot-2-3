package com.example.demo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CarRepository;

@RestController
public class CarController {

	@Autowired
	CarRepository carRepository;
	
	@RequestMapping("/insert_car")
	public String insertCar() {
		Car c1=new Car("Opel Astra",1995);
		Car c2=new Car("Renault Megane",2005);
		Car c3=new Car("Honda Civic",2013);
		Car c4=new Car("Ford Focus",2016);
		Car c5=new Car("Opel İnsignia",2014);
		
		carRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		return "İnsert Cars .......";
	}
	
	@GetMapping("/cars_2")
	public ResponseEntity<List<Car>> FindAllCars_1() {
		List<Car> cars= (List<Car>) carRepository.findAll();
		return ResponseEntity.ok(cars);
	}
	
	@Transactional(readOnly=true)
	@GetMapping("/cars_1")
	public ResponseEntity<List<Car>> FindAllCars_2() {
		List<Car> cars=carRepository.findAllCars();
		return ResponseEntity.ok(cars);
	}
	
	
}
