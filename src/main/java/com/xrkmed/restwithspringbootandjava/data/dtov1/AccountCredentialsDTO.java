package com.xrkmed.restwithspringbootandjava.data.dtov1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;


public class AccountCredentialsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public AccountCredentialsDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountCredentialsDTO other = (AccountCredentialsDTO) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
	
	
	
	
}
