package com.martin.employeecreator;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public class CreateEmployeeDto {

  @NotBlank
  String firstName;

  public CreateEmployeeDto(
    String firstName,
    String middleName,
    String lastName,
    String email,
    String homeAddress,
    int phoneNumber
  ) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.email = email;
    this.homeAddress = homeAddress;
    this.phoneNumber = phoneNumber;
  }

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
