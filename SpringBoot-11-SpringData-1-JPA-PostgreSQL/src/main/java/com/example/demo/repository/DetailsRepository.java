package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {

}
