package com.javaegitimleri.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.app.dao.PersonelRepository;
import com.javaegitimleri.app.dao.PetRepository;
import com.javaegitimleri.app.exception.OwnerNotFoundException;
import com.javaegitimleri.app.model.Personel;

@Service
@Transactional(rollbackFor=Exception.class)
public class AppServiceImp implements AppService {
	
	
	private PersonelRepository personelRepository;
	
	private PetRepository petrepository;
	
	@Autowired
	public void setPersonelRepository(PersonelRepository personelRepository) {
		this.personelRepository = personelRepository;
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Personel> findPersonels() {
		// TODO Auto-generated method stub
		return personelRepository.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Personel> findPersonel(String firstName) {
		// TODO Auto-generated method stub
		return personelRepository.findByFirstName(firstName);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Personel findPersonel(Long id) throws OwnerNotFoundException {
		// TODO Auto-generated method stub
		Personel personel=personelRepository.findById(id);
		if (personel==null) throw new OwnerNotFoundException("Personel not found with id : "+id); 
			return personel;
	}

	@Override
	public void createPersonel(Personel personel) {
		personelRepository.create(personel);

	}

	@Override
	public Personel update(Personel personel) {
		// TODO Auto-generated method stub
		return personelRepository.update(personel);
	}

	@Override
	public void delete(Long id) {
		personelRepository.delete(id);

	}

}
