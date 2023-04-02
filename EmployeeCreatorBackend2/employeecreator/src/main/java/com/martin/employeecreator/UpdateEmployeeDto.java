package com.martin.employeecreator;

import jakarta.validation.constraints.Size;
import java.util.Date;

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

  String contractType;

  public String getContractType() {
    return contractType;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  String phoneNumber;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  String homeAddress;

  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

  String email;

  public UpdateEmployeeDto(
    @Size(min = 1) String firstName,
    @Size(min = 1) String middleName,
    @Size(min = 1) String lastName,
    String contractType,
    String phoneNumber,
    String homeAddress,
    String email,
    Date startDate,
    Date endDate
  ) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.contractType = contractType;
    this.phoneNumber = phoneNumber;
    this.homeAddress = homeAddress;
    this.email = email;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  Date startDate;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  Date endDate;

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}
