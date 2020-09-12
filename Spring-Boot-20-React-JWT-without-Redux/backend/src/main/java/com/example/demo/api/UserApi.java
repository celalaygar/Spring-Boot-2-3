package com.example.demo.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.error.ApiError;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImp;
import com.example.demo.util.ApiPaths;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@CrossOrigin
public class UserApi {
	private final UserService service;

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {

		return ResponseEntity.ok(service.getUser(id));
	}

	@GetMapping("/hello")
	public ResponseEntity<String> getHello( ) {

		return ResponseEntity.ok("hello spring boot");
	}
	@PostMapping
	public ResponseEntity<?> postUser(@Valid @RequestBody User dto)  {

		return ResponseEntity.ok(service.save(dto));
	}

	@PutMapping("/[id}")
	public ResponseEntity<?> getUser(@PathVariable Long id, @RequestBody UserDto dto) {

		return ResponseEntity.ok(null);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {

		return ResponseEntity.ok(service.deleteUser(id));
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
	
	
}
