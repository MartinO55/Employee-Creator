package com.martin.employeecreator;

import jakarta.validation.constraints.NotBlank;

public class CreateEmployeeDto {

  @NotBlank
  String firstName;

  String middleName;

  @NotBlank
  String lastName;

  @NotBlank
  String email;

  @NotBlank
  String homeAddress;

  @NotBlank
  int phoneNumber;

  @NotBlank
  int contractType;

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
}
