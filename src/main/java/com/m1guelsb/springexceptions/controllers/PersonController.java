package com.m1guelsb.springexceptions.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1guelsb.springexceptions.dtos.PersonDto;
import com.m1guelsb.springexceptions.entities.Person;
import com.m1guelsb.springexceptions.services.PersonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/api/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping
  public ResponseEntity<Person> create(
      @RequestBody @Valid @NotNull PersonDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(personService.create(dto));
  }

  @GetMapping
  public ResponseEntity<List<Person>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(personService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Person>> findById(@PathVariable @NotNull Long id) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(personService.findById(id));
  }
}
