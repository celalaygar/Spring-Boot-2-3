package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.UploadImageDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.model.User;

public interface UserService {
	public ResponseEntity<?> save(@Valid User user);

	public Boolean deleteUser(Long id);

	public UserDto getUser(String username);

	public Page<UserDto> getAll(Pageable page,String authHeader ) ;

	public ResponseEntity<?> updateUser(String authHeader,String username,UserUpdateDto dto);

	public  ResponseEntity<?> uploadImage(String authHeader, String username, UploadImageDto dto);
}
