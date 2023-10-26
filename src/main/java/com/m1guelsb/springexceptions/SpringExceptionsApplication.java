package com.m1guelsb.springexceptions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.m1guelsb.springexceptions.repositories.PersonRepository;

@SpringBootApplication
public class SpringExceptionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExceptionsApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PersonRepository personRepository) {
		return args -> personRepository.deleteAll();
	}
}
