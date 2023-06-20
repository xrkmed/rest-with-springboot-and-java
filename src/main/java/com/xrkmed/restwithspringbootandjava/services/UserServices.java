package com.xrkmed.restwithspringbootandjava.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.xrkmed.restwithspringbootandjava.Controllers.PersonController;
import com.xrkmed.restwithspringbootandjava.Exceptions.RequiredObjectIsNullException;
import com.xrkmed.restwithspringbootandjava.Exceptions.ResourceNotFoundException;
import com.xrkmed.restwithspringbootandjava.Repositories.PersonRepository;
import com.xrkmed.restwithspringbootandjava.Repositories.UserRepository;
import com.xrkmed.restwithspringbootandjava.data.dtov1.PersonDTO;
import com.xrkmed.restwithspringbootandjava.mapper.DozerMapper;
import com.xrkmed.restwithspringbootandjava.model.Person;

@Service
public class UserServices implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	public UserServices(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username);
		if(user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException(String.format("%s nao foi encontrado!", username));
		}
	}
	
}
