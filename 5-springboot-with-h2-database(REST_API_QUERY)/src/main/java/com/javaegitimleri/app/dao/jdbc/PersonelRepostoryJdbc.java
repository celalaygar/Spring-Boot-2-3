package com.javaegitimleri.app.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.javaegitimleri.app.dao.PersonelRepository;
import com.javaegitimleri.app.dao.PetRepository;
import com.javaegitimleri.app.model.Personel;


@Repository("personelRepository")
public class PersonelRepostoryJdbc implements PersonelRepository {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	private PetRepository petRepository;
	
	private RowMapper<Personel> rowMapper=new RowMapper<Personel>() {

		@Override
		public Personel mapRow(ResultSet rs, int rowNum) throws SQLException {
			Personel personel=new Personel();
			personel.setId(rs.getLong("id"));
			personel.setFirstname(rs.getString("first_name"));
			personel.setLastname(rs.getString("last_name"));
			
			return personel;
		}	
	};
	
	@Autowired
	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	@Override
	public List<Personel> findAll() {
		String sql="select * from p_personel";
		return jdbctemplate.query(sql, rowMapper);
	}

	@Override
	public Personel findById(Long id) {
		String sql="select * from p_personel where id = ? ";
		return DataAccessUtils.singleResult(jdbctemplate.query(sql, rowMapper,id));
	}

	@Override
	public List<Personel> findByFirstName(String firstname) {
		String sql="select * from p_personel where first_name like ?";
		return jdbctemplate.query(sql, rowMapper,"%"+firstname);
	}

	@Override
	public void create(Personel personel) {
		String sql="INSERT INTO p_personel (id,first_name,last_name) VALUES(?,?,?)";
		jdbctemplate.update(sql, personel.getId(),personel.getFirstname(),personel.getLastname());

	}

	@Override
	public Personel update(Personel personel) {
		String sql="update p_personel set first_name = ? where id = ?";
		jdbctemplate.update(sql, personel.getFirstname(),personel.getId());
		return personel;
	}

	@Override
	public void delete(Long id) {	
		petRepository.deleteByOwnerId(id);
		String sql="DELETE  FROM p_personel where id=?";
		jdbctemplate.update(sql, id);
		//if(true) throw new RuntimeException("testing rollback"); 
	}

}
