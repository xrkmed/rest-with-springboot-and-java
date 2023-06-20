package com.xrkmed.restwithspringbootandjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xrkmed.restwithspringbootandjava.Repositories.UserRepository;
import com.xrkmed.restwithspringbootandjava.data.dtov1.AccountCredentialsDTO;
import com.xrkmed.restwithspringbootandjava.data.dtov1.TokenDTO;
import com.xrkmed.restwithspringbootandjava.securityJwt.JWTTokenProvider;

@Service
public class AuthServices {

	@Autowired
	private JWTTokenProvider tokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity signin(AccountCredentialsDTO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			var user = repository.findByUsername(username);
			
			var tokenResponse = new TokenDTO();
			if(user != null) {
				tokenResponse = tokenProvider.createAccessToken(username, user.getRoles());
			}else {
				throw new UsernameNotFoundException("Username not found");
			}
			
			return ResponseEntity.ok(tokenResponse);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BadCredentialsException("Invalid username/password supplied! " + e.getMessage());
		}
	}
}
