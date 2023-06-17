package com.xrkmed.restwithspringbootandjava.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xrkmed.restwithspringbootandjava.Exceptions.UnsupportedMathOperationException;
import com.xrkmed.restwithspringbootandjava.model.Person;
import com.xrkmed.restwithspringbootandjava.services.PersonServices;

@RequestMapping("/v1/person")
@RestController
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findById(
			@PathVariable(value="id") String id) {
		return ResponseEntity.ok(service.findById(id));
	}

}
