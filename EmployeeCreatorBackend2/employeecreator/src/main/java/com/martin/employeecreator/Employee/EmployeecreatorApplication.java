package com.martin.employeecreator.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.martin.employeecreator.Employee" })
public class EmployeecreatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeecreatorApplication.class, args);
  }
}
