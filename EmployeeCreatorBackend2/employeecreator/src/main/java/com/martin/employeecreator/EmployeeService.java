package com.martin.employeecreator;

import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ModelMapper mapper;

  @Autowired
  public Employee create(CreateEmployeeDto data) {
    String firstName = data.getFirstName().trim();
    String middleName = data.getMiddleName().trim();
    String lastName = data.getLastName().trim();
    String email = data.getEmail().trim();
    String homeAddress = data.getHomeAddress().trim();
    String phoneNumber = data.getPhoneNumber().trim();
    String contractType = data.getContractType();
    Date startDate = data.getStartDate();
    Date endDate = data.getEndDate();

    Employee newEmployee = new Employee();

    newEmployee.setFirstName(firstName);
    newEmployee.setMiddleName(middleName);
    newEmployee.setLastName(lastName);
    newEmployee.setEmail(email);
    newEmployee.setHomeAddress(homeAddress);
    newEmployee.setPhoneNumber(phoneNumber);
    newEmployee.setContractType(contractType);
    newEmployee.setStartDate(startDate);
    newEmployee.setEndDate(endDate);
    newEmployee.setCreatedAt(new Date());

    return this.employeeRepository.save(newEmployee);
  }

  public List<Employee> getEmployees() {
    return this.employeeRepository.findAll();
  }

  public Optional<Employee> findById(Long id) {
    return this.employeeRepository.findById(id);
  }

  public void deleteEmployeeById(Long id) {
    this.employeeRepository.deleteById(id);
  }

  public void deleteAllEmployees() {
    this.employeeRepository.deleteAll();
  }

  public Optional<Employee> updateAnEmployeeById(
    Long id,
    CreateEmployeeDto data
  ) {
    Optional<Employee> maybeEmployee = this.findById(id);
    if (maybeEmployee.isEmpty()) {
      return maybeEmployee;
    }
    Employee existingEmployee = maybeEmployee.get();

    mapper.map(data, existingEmployee);
    return Optional.of(this.employeeRepository.save(existingEmployee));
  }
}
