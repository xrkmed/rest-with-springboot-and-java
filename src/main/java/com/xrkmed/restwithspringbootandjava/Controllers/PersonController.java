package com.xrkmed.restwithspringbootandjava.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xrkmed.restwithspringbootandjava.data.dtov1.PersonDTO;
import com.xrkmed.restwithspringbootandjava.services.PersonServices;

@RequestMapping("/v1/persons")
@RestController
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> findById(
			@PathVariable(value="id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person
			) {
		return ResponseEntity.ok(service.create(person));
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person){
		return ResponseEntity.ok(service.update(person));
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}
