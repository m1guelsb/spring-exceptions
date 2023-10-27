package com.m1guelsb.springexceptions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1guelsb.springexceptions.dtos.PersonDto;
import com.m1guelsb.springexceptions.entities.Person;
import com.m1guelsb.springexceptions.exceptions.NotFoundException;
import com.m1guelsb.springexceptions.repositories.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public Person create(PersonDto dto) {
    var person = new Person();
    person.setName(dto.getName());
    person.setEmail(dto.getEmail());
    person.setAge(dto.getAge());

    return personRepository.save(person);
  }

  public Person findById(Long id) throws NotFoundException {
    return personRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Person not found: " + id));
  }
}
