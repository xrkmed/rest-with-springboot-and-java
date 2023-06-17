package com.xrkmed.restwithspringbootandjava.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.xrkmed.restwithspringbootandjava.model.Address;
import com.xrkmed.restwithspringbootandjava.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {
		logger.info("Finding one person!");
		Person person = new Person(counter.getAndIncrement(), "Joao", "da Silva", new Address("R. Das Graças", "bairroTemplate", "cidadeTemplate", "estadoTemplate", 88134000L), "M");
		return person;
	}
	
}
