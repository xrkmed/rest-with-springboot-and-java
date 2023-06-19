package com.xrkmed.restwithspringbootandjava.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrkmed.restwithspringbootandjava.Exceptions.ResourceNotFoundException;
import com.xrkmed.restwithspringbootandjava.Repositories.PersonRepository;
import com.xrkmed.restwithspringbootandjava.data.dtov1.PersonDTO;
import com.xrkmed.restwithspringbootandjava.mapper.DozerMapper;
import com.xrkmed.restwithspringbootandjava.model.Person;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;

	public List<PersonDTO> findAll(){
		return DozerMapper.parseListObjectts(repository.findAll(), PersonDTO.class);
	}
	
	public PersonDTO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerMapper.parseObject(entity, PersonDTO.class);
	}
	
	public PersonDTO create(PersonDTO person) {
		var entity = DozerMapper.parseObject(person, Person.class);
		var DTO = repository.save(entity);
		return DozerMapper.parseObject(DTO, PersonDTO.class);
	}
	
	public PersonDTO update(PersonDTO person) {
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		return DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
}
