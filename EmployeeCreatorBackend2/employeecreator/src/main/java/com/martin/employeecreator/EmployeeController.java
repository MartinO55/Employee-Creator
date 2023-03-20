package com.martin.employeecreator;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @PostMapping
  public String createEmployee(@Validated @RequestBody CreateEmployeeDto data) {
    return "create an employee";
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
