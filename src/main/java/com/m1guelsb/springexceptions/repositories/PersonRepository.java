package com.m1guelsb.springexceptions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m1guelsb.springexceptions.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
