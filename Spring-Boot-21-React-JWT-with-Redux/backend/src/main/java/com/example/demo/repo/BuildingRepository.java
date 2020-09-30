package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Long>{

}
