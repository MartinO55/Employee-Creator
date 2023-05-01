package com.martin.employeecreator.Employee;

import com.electronwill.nightconfig.core.file.NoFormatFoundException;
import jakarta.validation.Valid;
//import jakarta.validation.OverridesAttribute.List;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<?> deleteAllEmployees() {
    this.employeeService.deleteAllEmployees();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
    Optional<Employee> maybeEmployee = this.employeeService.findById(id);

    if (maybeEmployee.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    this.employeeService.deleteEmployeeById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long id) {
    Optional<Employee> maybeEmployee = this.employeeService.findById(id);

    if (maybeEmployee.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(maybeEmployee.get(), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateAnEmployeeById(
    @PathVariable Long id,
    @Valid @RequestBody CreateEmployeeDto data
  ) {
    Employee updatedEmployee =
      this.employeeService.updateAnEmployeeById(id, data)
        .orElseThrow(() ->
          new NoFormatFoundException("Could not find employee with id " + id)
        );

    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
  }
}
