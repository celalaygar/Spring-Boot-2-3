package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	Page<User> findByUsernameNot(String username, Pageable page);
	
	@Query("select u from User u where u.id = :id and u.status = 1")
	Optional<User> findUserById(Long id);
	

	@Query("select u from User u where u.username = :username and u.status = 1")
	User findUserByUsernameWithStatusOne(String username);
}
