package com.martin.employeecreator;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<Employee> createEmployee(
    @Valid @RequestBody CreateEmployeeDto data
  ) {
    Employee createdEmployee = this.employeeService.create(data);
    return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
  }

  @GetMapping
  public String getEmployees() {
    return "Get All employees";
  }

  @GetMapping
  public String getEmployeeByID() {
    return "Get Employee by ID";
  }
}
