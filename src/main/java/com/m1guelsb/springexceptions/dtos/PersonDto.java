package com.m1guelsb.springexceptions.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonDto {
  @NotBlank(message = "name: Is required")
  @Length(min = 3, max = 100, message = "title: Must be of 3 - 100 characters")
  String name;

  @NotBlank(message = "email: Is required")
  @Email(message = "email: Invalid format")
  String email;

  @NotNull(message = "age: Is required")
  @Min(value = 1, message = "age: Must be greater than 0")
  @Max(value = 100, message = "age: Must be less than 100")
  Integer age;
}