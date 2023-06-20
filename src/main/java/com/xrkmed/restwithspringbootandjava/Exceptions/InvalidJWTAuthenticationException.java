package com.xrkmed.restwithspringbootandjava.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJWTAuthenticationException extends AuthenticationException {
	
	public InvalidJWTAuthenticationException(String ex) {
		super(ex);
	}
	
	private static final long serialVersionUID = 1L;
}
