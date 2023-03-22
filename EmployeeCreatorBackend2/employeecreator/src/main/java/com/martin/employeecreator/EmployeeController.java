package com.martin.employeecreator;

import jakarta.validation.Valid;
//import jakarta.validation.OverridesAttribute.List;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<List<Employee>> getEmployees() {
    List<Employee> allEmployees = this.employeeService.getEmployees();
    return new ResponseEntity<>(allEmployees, HttpStatus.OK);
  }

  @DeleteMapping
  public String deleteAllEmployees() {
    return "fire EVERYONE";
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long id) {
    Optional<Employee> maybeEmployee = this.employeeService.findById(id);

    if (maybeEmployee.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(maybeEmployee.get(), HttpStatus.OK);
  }
}
