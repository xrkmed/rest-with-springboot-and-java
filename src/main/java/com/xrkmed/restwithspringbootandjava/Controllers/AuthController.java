package com.xrkmed.restwithspringbootandjava.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xrkmed.restwithspringbootandjava.data.dtov1.AccountCredentialsDTO;
import com.xrkmed.restwithspringbootandjava.services.AuthServices;

@RequestMapping("/auth")
@RestController
public class AuthController {

	@Autowired
	AuthServices authServices;
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/signin")
	public ResponseEntity signin(@RequestBody AccountCredentialsDTO data) {
		if(data == null || data.getUsername() == null || data.getUsername().isBlank() || data.getPassword() == null || data.getPassword().isBlank()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Client request");
		}
		
		var token = authServices.signin(data);
		if(token == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Token");
		}
		
		return token;
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/refresh/{username}")
	public ResponseEntity refreshToken(@PathVariable(value = "username") String username,
			@RequestHeader(name = "Authorization") String authorization) {
		if(authorization == null || authorization.isBlank()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid header authorization!");
		}
		
		var token = authServices.refreshToken(username, authorization);
		if(token == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid credentials to create refresh token");
		}
		
		return token;
	}
}
