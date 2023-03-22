package com.martin.employeecreator;

import jakarta.transaction.Transactional;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee create(CreateEmployeeDto data) {
    String firstName = data.getFirstName().trim();
    String middleName = data.getMiddleName().trim();
    String lastName = data.getLastName().trim();
    String email = data.getEmail().trim();
    String homeAddress = data.getHomeAddress().trim();
    String phoneNumber = data.getPhoneNumber().trim();
    String contractType = data.getContractType();

    Employee newEmployee = new Employee();

    newEmployee.setFirstName(firstName);
    newEmployee.setMiddleName(middleName);
    newEmployee.setLastName(lastName);
    newEmployee.setEmail(email);
    newEmployee.setHomeAddress(homeAddress);
    newEmployee.setPhoneNumber(phoneNumber);
    newEmployee.setContractType(contractType);
    newEmployee.setCreatedAt(new Date());

    return this.employeeRepository.save(newEmployee);
  }
}
