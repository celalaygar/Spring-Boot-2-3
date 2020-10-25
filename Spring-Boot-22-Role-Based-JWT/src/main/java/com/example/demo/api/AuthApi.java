package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthDto;
import com.example.demo.entity.User;
import com.example.demo.jwt.JwtResponse;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class AuthApi {
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repository;
	
	@PostMapping("/api/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthDto authenticationRequest) throws Exception {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtTokenProvider.generateToken(authentication);
			String username = authenticationRequest.getUsername();
			Optional<User> opt = repository.findByUsername(username);
			User user;
			if(!opt.isPresent()){
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("bad Request");
			}
			user = opt.get();
			return ResponseEntity.ok(new JwtResponse(username,jwt,null));
		}catch (BadCredentialsException e) {
			//ApiError error = new ApiError(401, "Unauthorized request : "+e.getMessage(), "/api/login");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("bad Request");
		}
		catch (Exception e) {
			throw e;
		}
	
	}
	
}
