package com.javaegitimleri.app.dao;

import java.util.List;

import com.javaegitimleri.app.model.Personel;
public interface PersonelRepository {

	List<Personel> findAll();
	Personel findById(Long id);
	List<Personel> findByFirstName(String firstname);
	void create(Personel personel);
	Personel update(Personel personel );
	void delete(Long id);
}
