package com.xrkmed.restwithspringbootandjava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xrkmed.restwithspringbootandjava.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
