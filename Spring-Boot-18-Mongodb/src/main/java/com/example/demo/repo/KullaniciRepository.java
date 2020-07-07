package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Kullanici;

public interface KullaniciRepository extends MongoRepository<Kullanici, String> {

	
}
