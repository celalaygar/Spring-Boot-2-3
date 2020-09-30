package com.example.demo.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UploadImageDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.error.ApiError;
import com.example.demo.model.User;
import com.example.demo.model.annotation.CurrentUser;
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

	// localhost:8501/api/user/users?page=1&size=4
	@GetMapping("/users")
	public ResponseEntity<Page<UserDto>> getAll(@RequestHeader("Authorization") String authHeader, Pageable page) {

		return ResponseEntity.ok(service.getAll(page, authHeader));
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable String username) {
		return ResponseEntity.ok(service.getUser(username));
	}

	@PostMapping
	public ResponseEntity<?> postUser(@Valid @RequestBody User dto) {
		return ResponseEntity.ok(service.save(dto));
	}

	@PutMapping("/{username}")
	public ResponseEntity<?> updateUser(@RequestHeader("Authorization") String authHeader,
			@PathVariable String username,@Valid @RequestBody UserUpdateDto dto) {

		return ResponseEntity.ok(service.updateUser(authHeader, username, dto));
	}
	@PutMapping("/upload-image/{username}")
	public ResponseEntity<?> uploadImage(@RequestHeader("Authorization") String authHeader,
			@PathVariable String username,@RequestBody UploadImageDto dto) { 
		return ResponseEntity.ok(service.uploadImage(authHeader, username, dto));
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
