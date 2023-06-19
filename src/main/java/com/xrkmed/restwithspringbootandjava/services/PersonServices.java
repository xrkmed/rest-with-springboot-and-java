package com.xrkmed.restwithspringbootandjava.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrkmed.restwithspringbootandjava.Exceptions.ResourceNotFoundException;
import com.xrkmed.restwithspringbootandjava.Repositories.PersonRepository;
import com.xrkmed.restwithspringbootandjava.model.Person;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;

	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
}
