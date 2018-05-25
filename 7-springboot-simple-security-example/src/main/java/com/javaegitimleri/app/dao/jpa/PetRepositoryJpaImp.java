package com.javaegitimleri.app.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.app.dao.PetRepository;
import com.javaegitimleri.app.model.Pet;

@Repository("petRepository")
public class PetRepositoryJpaImp implements PetRepository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return entitymanager.find(Pet.class, id);
	}

	@Override
	public List<Pet> findByPersonelId(Long PersonelId) {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("SELECT * FROM p_pet WHERE personel_id = :personel_id",  Pet.class)
				.setParameter("personel_id", PersonelId).getResultList();
	}

	@Override
	public void create(Pet pet) {
		entitymanager.persist(pet);

	}

	@Override
	public Pet update(Pet pet) {
		// TODO Auto-generated method stub
		return entitymanager.merge(pet);
	}
	
	public void delete(Long id) {
		entitymanager.remove(entitymanager.getReference(Pet.class, id));
	}
	
	@Override
	public void deleteByOwnerId(Long PersonelId) {
		// TODO Auto-generated method stub
		entitymanager.createQuery("DELETE FROM p_pet WHERE personel_id = :personel_id", Pet.class)
		.setParameter("personel_id", PersonelId).getResultList(); 
		

	}

}
