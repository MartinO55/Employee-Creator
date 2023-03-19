package com.example.demo;

import jakarta.annotation.Nonnull;

public class CreateEmployeeDto {

  @Nonnull
  String firstName;

  String middleName;

  @Nonnull
  String lastName;

  @Nonnull
  String email;

  @Nonnull
  String homeAddress;

  @Nonnull
  int phoneNumber;

  @Nonnull
  int contractType;
}
