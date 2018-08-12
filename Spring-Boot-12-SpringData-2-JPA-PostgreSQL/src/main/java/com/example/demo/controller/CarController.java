package com.example.demo.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.exception.CarNotFoundException;
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
	
	
	// insert  car methods Try with postman to insert car data 
	@RequestMapping(method = RequestMethod.POST, value = "/car")
	public ResponseEntity<URI> createCar(@RequestBody Car car) {
		try {
			carRepository.save(car);
			Long id = car.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// update car you can try updating data on postman
	@RequestMapping(method=RequestMethod.PUT,value="/car/{id}")
	public ResponseEntity<List<Car>> updatePersonels(@PathVariable("id") Long id, @RequestBody Car car){
		try {
			Car c=carRepository.findById(id).get();
			c.setName(car.getName());
			c.setModel(car.getModel());
			carRepository.save(c);
			return ResponseEntity.ok().build();
		} catch (CarNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//delete car 
	@RequestMapping(method=RequestMethod.DELETE,value="/car/{id}")
	public ResponseEntity<?> deletePersonel(@PathVariable("id") Long id){
		try {
			carRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (CarNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	} 
	
	@GetMapping("/cars_2")
	public ResponseEntity<List<Car>> FindAllCars_1() {
		List<Car> cars= (List<Car>) carRepository.findAll();
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/cars_1")
	public ResponseEntity<List<Car>> FindAllCars_2() {
		List<Car> cars=carRepository.findAllCars();
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/car1/{id}")
	public ResponseEntity<Car>FindCar_1Byid(@PathVariable Long id) {
		Optional<Car> cars=carRepository.findById(id);
		return ResponseEntity.ok(cars.get());
	}
	@GetMapping("/car2/{id}")
	public ResponseEntity<Car>FindCar_2Byid(@PathVariable Long id) {
		Car car=carRepository.findCarDataById(id);
		return ResponseEntity.ok(car);
	}
	@GetMapping("/car_with_name/{name}")
	public ResponseEntity<Car>FindCar_2Byname(@PathVariable String name) {
		Car car=carRepository.findCarDataByname(name);
		return ResponseEntity.ok(car);
	}
	
	@GetMapping("/car_with_model/{model}")
	public ResponseEntity<List<Car>>FindCar_2Byname(@PathVariable int model) {
		List<Car> cars=carRepository.findCarDataBymodel(model);
		return ResponseEntity.ok(cars);
	}
}
