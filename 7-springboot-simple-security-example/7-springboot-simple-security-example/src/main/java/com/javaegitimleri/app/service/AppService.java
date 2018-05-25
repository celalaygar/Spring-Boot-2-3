package com.javaegitimleri.app.service;

import java.util.List;

import com.javaegitimleri.app.exception.OwnerNotFoundException;
import com.javaegitimleri.app.model.Personel;

public interface AppService {

	List<Personel> findPersonels();
	List<Personel> findPersonel(String firstName);
	Personel findPersonel(Long id) throws OwnerNotFoundException;
	void createPersonel(Personel personel);
	Personel update(Personel personel);
	void delete(Long id);
}
