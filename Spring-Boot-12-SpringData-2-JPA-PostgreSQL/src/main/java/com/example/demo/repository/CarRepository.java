package com.example.demo.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

	@Query("select c from Car c")
	List<Car> findAllCars();

	@Query("select c from Car c Where c.id= :id")
	Car findCarDataById(@Param("id") Long id);
	
	@Query("select c from Car c Where c.name= :name")
	Car findCarDataByname(@Param("name") String name);
	
	
	@Query("select c from Car c Where c.model= :model")
	List<Car> findCarDataBymodel(@Param("model") int model);
}
