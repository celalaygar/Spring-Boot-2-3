package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.UserDto;
import com.example.demo.error.ApiError;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

	private final UserRepository repository;
	private final ModelMapper mapper;
	private final Logger logger;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public ResponseEntity<?> save(@Valid User user) {
//		if (dto.getEmail() == null || dto.getEmail().isEmpty()
//				|| dto.getUsername() == null || dto.getUsername().isEmpty()
//				|| dto.getPassword() == null || dto.getPassword().isEmpty()
//				|| dto.getRepeatPassword() == null || dto.getRepeatPassword().isEmpty()) {
//			HashMap<String, String> map = new HashMap<>();
//			if(dto.getEmail() == null || dto.getEmail().isEmpty()) {
//				map.put("email", "Email can not be empty");
//				logger.error("Email can not be empty or null ");
//			}
//			if(dto.getUsername() == null || dto.getUsername().isEmpty()) {
//				map.put("username", "Username can not be empty");
//				logger.error("Username can not be empty or null ");
//			}
//			if(dto.getPassword() == null || dto.getPassword().isEmpty()) {
//				map.put("password", "Password can not be empty");
//				logger.error("Password can not be empty or null ");
//			}
//			if(dto.getRepeatPassword() == null || dto.getRepeatPassword().isEmpty()) {
//				map.put("repeatpassword", "Repeat Password  can not be empty");
//				logger.error("Repeat Password  can not be empty or null ");
//			}
//			ApiError error = new ApiError(400, "Null Pointer Problem", null);
//			error.setValidationErrors(map);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//		}
		if(!user.getPassword().equals(user.getRepeatPassword())) {
			HashMap<String, String> map = new HashMap<>();
			map.put("repeatPassword", "Passwords must be same.");
			ApiError error = new ApiError(400, "Email, Username and Password can not be empty or null", null);
			error.setValidationErrors(map);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		//User user = mapper.map(dto, User.class);
		user.setCreatedDate(new Date());
		user.setStatus(1);
		user.setRealPassword(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getRealPassword()));
		user = repository.save(user);
		logger.info("User is saved");

		UserDto dto = mapper.map(user, UserDto.class);
		return ResponseEntity.ok(dto);
	}
//	@ExceptionHandler
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ApiError handleValidationException(MethodArgumentNotValidException ex) {
//		ApiError error = new ApiError(400, "Null Pointer Problem", null);
//		Map<String, String> validationErrors = new HashMap<>();
//		for (FieldError fieldError  : ex.getBindingResult().getFieldErrors()) {
//			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//		} 
//		error.setValidationErrors(validationErrors);
//		return error;
//	}
	public UserDto getUser(Long id) {
		User user = repository.findUserById(id);

		if (user == null) {
			logger.error("There is no user with " + id);
			throw new IllegalArgumentException("There is no user with " + id);
		}
		logger.info("User is ok");
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	public Boolean deleteUser(Long id) {
		User user = repository.getOne(id);

		if (user == null)
			throw new IllegalArgumentException("There is no user with " + id);
		user.setStatus(0);
		repository.save(user);
		return true;
	}
}
