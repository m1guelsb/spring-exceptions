package com.m1guelsb.springexceptions.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String ex) {
    super(ex);
  }

}