package com.xrkmed.restwithspringbootandjava.services;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.xrkmed.restwithspringbootandjava.Controllers.PersonController;
import com.xrkmed.restwithspringbootandjava.Exceptions.RequiredObjectIsNullException;
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
		var persons = DozerMapper.parseListObjectts(repository.findAll(), PersonDTO.class);
		persons.stream().forEach(x -> {
			x.add(linkTo(methodOn(PersonController.class).findById(x.getId())).withSelfRel());
		});
		
		return persons;
	}
	
	public PersonDTO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		PersonDTO object = DozerMapper.parseObject(entity, PersonDTO.class);
		object.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return object;
	}
	
	public PersonDTO create(PersonDTO person) {
		if(person == null)
			throw new RequiredObjectIsNullException("null person create");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var DTO = repository.save(entity);
		PersonDTO object = DozerMapper.parseObject(DTO, PersonDTO.class);
		return object.add(linkTo(methodOn(PersonController.class).findById(DTO.getId())).withSelfRel());
	}
	
	public PersonDTO update(PersonDTO person) {
		if(person == null)
			throw new RequiredObjectIsNullException("null person update");
		
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		PersonDTO object = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
		return object.add(linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel());
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
}
