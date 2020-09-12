package com.example.demo.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.jwt.config.JwtRequest;
import com.example.demo.jwt.config.JwtResponse;
import com.example.demo.jwt.config.JwtTokenUtil;
import com.example.demo.jwt.config.JwtUserDetails;
import com.example.demo.jwt.config.JwtUserDetailsService;
import com.example.demo.util.ApiPaths;

@RestController
@CrossOrigin
@RequestMapping(ApiPaths.LoginCtrl.CTRL)
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		try {
			
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtTokenUtil.generateToken(authentication);
			String username = authenticationRequest.getUsername();
			return ResponseEntity.ok(new JwtResponse(username,jwt));
		}catch (BadCredentialsException e) {
			ApiError error = new ApiError(401, "Unauthorized request : "+e.getMessage(), "/api/login");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		catch (Exception e) {
			throw e;
		}
	
	}
 
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
}
