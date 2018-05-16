package com.javaegitimleri.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.app.model.Personel;

@Repository
public class PersonelRepositoryImp implements PersonelRepository {

	private Map<Long, Personel> personelMap=new HashMap<>();
	
	public PersonelRepositoryImp() {
		Personel p1=new Personel();
		
		p1.setId(1L);
		p1.setFirstname("Kemal");
		p1.setLastname("Başaran");
		
		Personel p2=new Personel();
		p2.setId(2L);
		p2.setFirstname("Celal");
		p2.setLastname("Aygar");
		
		Personel p3=new Personel();
		p3.setId(3L);
		p3.setFirstname("Fatih");
		p3.setLastname("Terim");
		
		Personel p4=new Personel();
		p4.setId(4L);
		p4.setFirstname("Necati");
		p4.setLastname("Yavuz");
		
		Personel p5=new Personel();
		p5.setId(5L);
		p5.setFirstname("Orhan");
		p5.setLastname("Sultan");
		
		Personel p6=new Personel();
		p6.setId(6L);
		p6.setFirstname("Ferhat");
		p6.setLastname("Kahraman");

		Personel p7=new Personel();
		p7.setId(7L);
		p7.setFirstname("Celal");
		p7.setLastname("Gelir");
		
		personelMap.put(p1.getId(), p1);
		personelMap.put(p2.getId(), p2);
		personelMap.put(p3.getId(), p3);
		personelMap.put(p4.getId(), p4);
		personelMap.put(p5.getId(), p5);
		personelMap.put(p6.getId(), p6);
		personelMap.put(p7.getId(), p7);
	}
	
	@Override
	public List<Personel> findAll() {
		
		return new ArrayList<>(personelMap.values());
	}

	@Override
	public Personel findById(Long id) {
		// TODO Auto-generated method stub
		return personelMap.get(id);
	}

	@Override
	public List<Personel> findByFirstName(String firstname) {
		// TODO Auto-generated method stub
		return personelMap.values().stream().filter(o->o.getFirstname().equals(firstname)).collect(Collectors.toList());
	}

	@Override
	public void create(Personel personel) {
		personel.setId(new Date().getTime());
		personelMap.put(personel.getId(), personel);
	}

	@Override
	public Personel update(Personel personel) {
		personelMap.replace(personel.getId(), personel);
		return personel ;
	}

	@Override
	public void delete(Long id) {
		personelMap.remove(id);

	}

}
