package com.example.demo.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

	@Query("select c from Car c")
	List<Car> findAllCars();
	
}
