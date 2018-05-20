package com.javaegitimleri.app.dao;

import java.util.List;

import com.javaegitimleri.app.model.Pet;

public interface PetRepository {

	Pet findById(Long id );
	List<Pet> findByPersonelId(Long PersonelId);
	void create(Pet pet);
	Pet update(Pet pet);
	void deleteByOwnerId(Long PersonelId);
	
	
	
	
}
