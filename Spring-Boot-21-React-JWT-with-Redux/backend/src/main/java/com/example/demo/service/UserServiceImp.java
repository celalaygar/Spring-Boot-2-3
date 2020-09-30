package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.UploadImageDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.error.ApiError;
import com.example.demo.error.NotFoundException;
import com.example.demo.file.FileService;
import com.example.demo.jwt.config.JwtTokenUtil;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
	public static final String TOKEN_PREFIX = "Bearer ";
	private final UserRepository repository;
	private final ModelMapper mapper;
	private final Logger logger;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenUtil tokenUtil;
	private final FileService fileService;
	private String[] types = {"image/png","image/jpeg"};
	@Override
	@Transactional
	public Page<UserDto> getAll(Pageable page, String authHeader) { 
		Page<UserDto> pageDto = null;
		if(authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
			String username = getUsernameFromToken(authHeader);
			Page<User> pdoUser = repository.findByUsernameNot(username, page);
			pageDto = pdoUser.map(UserDto::new);
			return pageDto;
		}
		//Page<User> pageList = repository.findAll(page).map(UserDto::new); 
		pageDto = repository.findAll(page).map(UserDto::new); 
		return pageDto;
	}
	
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
	

	@Transactional
	public UserDto getUser(String username) {
		User user = repository.findUserByUsernameWithStatusOne(username);

		if (user==null) {
			logger.error("There is no user with " + username);
			throw new NotFoundException();
			//throw new IllegalArgumentException("There is no user with " + id);
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
	
	private String getUsernameFromToken(String authHeader) {
		Page<UserDto> pageDto = null;
		String username= null;
		if(authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
			String token = authHeader.replace(TOKEN_PREFIX, "");
			username = tokenUtil.getUsernameFromToken(token);
		}
		return username;
	}
	@Override
	public ResponseEntity<?> updateUser(String authHeader,String username,UserUpdateDto dto) {
		String userNameFromToken = getUsernameFromToken(authHeader);
		if(!userNameFromToken.equals(username)){
			logger.error("User Names cannot match");
			ApiError error = new ApiError(403, "User Names cannot match", "api/user/"+authHeader);
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
		}
		User user = repository.findUserByUsernameWithStatusOne(username);
		if (user==null) {
			logger.error("There is no user with " + username);
			throw new NotFoundException();
			//throw new IllegalArgumentException("There is no user with " + id);
		}
//		if(dto.getImage() != null) {
//			String oldImage = user.getImage();
//			try {
//				String fileName = fileService.writeBase64StringToFile(dto.getImage());
//				user.setImage(fileName);
//			} catch (IOException e) { 
//				e.printStackTrace();
//			}
//			fileService.deleteFile(oldImage);
//		}
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setBornDate(dto.getBornDate());
		user = repository.save(user);
		UserDto result = mapper.map(user, UserDto.class);
		logger.info("User updated");
		return ResponseEntity.ok(result);
	}

	public  ResponseEntity<?> uploadImage(String authHeader, String username, UploadImageDto dto){
		String userNameFromToken = getUsernameFromToken(authHeader);
		if(!userNameFromToken.equals(username)){
			logger.error("User Names cannot match");
			ApiError error = new ApiError(403, "User Names cannot match", "api/user/"+authHeader);
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
		}
		User user = repository.findUserByUsernameWithStatusOne(username);
		if (user==null) {
			logger.error("There is no user with " + username);
			throw new NotFoundException();
			//throw new IllegalArgumentException("There is no user with " + id);
		}
		if(dto.getImage() != null) {
			String oldImage = user.getImage();
			try {
				if(!fileService.isValidFileType(types,dto.getImage())) {
					ApiError error = new ApiError(400, "Image Type invalid", "api/user/upload-image/"+authHeader);
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
				} 
				String fileName = fileService.writeBase64StringToFile(dto.getImage());
				user.setImage(fileName);
			} catch (IOException e) { 
				e.printStackTrace();
			}
			fileService.deleteFile(oldImage);
		}
		user = repository.save(user);
		UserDto result = mapper.map(user, UserDto.class);
		logger.info("User updated");
		return ResponseEntity.ok(result);
	}
}
