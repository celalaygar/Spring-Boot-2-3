package com.javaegitimleri.app.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaegitimleri.app.dao.PetRepository;
import com.javaegitimleri.app.model.Pet;

@Repository
public class PetRepostoryJdbc implements PetRepository{

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public Pet findById(Long id) {
			
		return null;
	}

	@Override
	public List<Pet> findByPersonelId(Long PersonelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet update(Pet pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByOwnerId(Long PersonelId) {
		String sql="delete from p_pet where personel_id=?";
		jdbctemplate.update(sql, PersonelId);
		
		
	}

}
