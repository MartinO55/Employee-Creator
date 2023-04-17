package com.martin.employeecreator.Employee;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

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
  String phoneNumber;

  @NotBlank
  String contractType;

  @NotBlank
  Date startDate;

  Date endDate;

  public CreateEmployeeDto(
    String firstName,
    String middleName,
    String lastName,
    String email,
    String homeAddress,
    String phoneNumber,
    String contractType,
    Date startDate,
    Date endDate
  ) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.email = email;
    this.homeAddress = homeAddress;
    this.phoneNumber = phoneNumber;
    this.contractType = contractType;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getContractType() {
    return contractType;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}