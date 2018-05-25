package com.javaegitimleri.app.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.app.dao.PersonelRepository;
import com.javaegitimleri.app.model.Personel;


@Repository("personelRepository")
public class PersonelRepositoryJpaImp implements PersonelRepository {

	
	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public List<Personel> findAll(){
		// TODO Auto-generated method stub
		return entitymanager.createQuery("from Personel", Personel.class).getResultList();
	}

	@Override
	public Personel findById(Long id) {
	
		return entitymanager.find(Personel.class, id);
	}

	@Override
	public List<Personel> findByFirstName(String firstname) {
		
		return entitymanager.createQuery("from Personel where first_name = :first_name", Personel.class)
				.setParameter("first_name", firstname).getResultList();
	}

	@Override
	public void create(Personel personel) {
		entitymanager.persist(personel);

	}

	@Override
	public Personel update(Personel personel) {
		
		return entitymanager.merge(personel);
	}

	@Override
	public void delete(Long id) {
		entitymanager.remove(entitymanager.getReference(Personel.class, id));
	}
	

}
