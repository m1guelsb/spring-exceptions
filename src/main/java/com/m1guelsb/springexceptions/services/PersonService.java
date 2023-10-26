package com.m1guelsb.springexceptions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1guelsb.springexceptions.dtos.PersonDto;
import com.m1guelsb.springexceptions.entities.Person;
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

  public List<Person> findAll() {
    return personRepository.findAll();
  }

  public Optional<Person> findById(Long id) {
    return personRepository.findById(id);
  }
}
