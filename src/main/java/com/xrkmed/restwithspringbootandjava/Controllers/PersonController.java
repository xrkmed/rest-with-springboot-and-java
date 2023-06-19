package com.xrkmed.restwithspringbootandjava.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xrkmed.restwithspringbootandjava.Exceptions.UnsupportedMathOperationException;
import com.xrkmed.restwithspringbootandjava.model.Person;
import com.xrkmed.restwithspringbootandjava.services.PersonServices;

@RequestMapping("/v1/persons")
@RestController
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findById(
			@PathVariable(value="id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@RequestMapping(value = "/", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value = "/add", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> create(@RequestBody Person person
			) {
		return ResponseEntity.ok(service.create(person));
	}
	
	@RequestMapping(value = "/update",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> update(@RequestBody Person person){
		return ResponseEntity.ok(service.update(person));
	}
	
	@RequestMapping(value = "/delete",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}
