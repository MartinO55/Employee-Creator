package com.martin.employeecreator;

import jakarta.validation.constraints.Size;

public class UpdateEmployeeDto {

  @Size(min = 1)
  String firstName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Size(min = 1)
  String middleName;

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @Size(min = 1)
  String lastName;

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
