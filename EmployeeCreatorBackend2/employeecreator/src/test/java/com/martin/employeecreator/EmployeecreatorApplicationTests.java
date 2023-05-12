package com.martin.employeecreator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.martin.employeecreator.Employee.CreateEmployeeDto;
import com.martin.employeecreator.Employee.Employee;
import com.martin.employeecreator.Employee.EmployeeController;
import com.martin.employeecreator.Employee.EmployeeService;
import com.martin.employeecreator.Employee.EmployeecreatorApplication;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = EmployeecreatorApplication.class)
@ExtendWith(MockitoExtension.class)
class EmployeecreatorApplicationTests {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private EmployeeService employeeService;

  @InjectMocks
  private EmployeeController employeeController;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  //get All works
  @Test
  public void itShouldReturnOkToGetAllEmployees() throws Exception {
    mockMvc
      .perform(
        MockMvcRequestBuilders
          .get("/employees")
          .accept(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isOk());
  }

  //I would write an invalid employee test, but the DTO blocks you from trying to submit invalid data, so you cant even pass it to get the 400 returned
  @Test
  public void itShouldReturnOkToCreateValidEmployee() throws Exception {
    String firstName = "Little";
    String middleName = "Johny";
    String lastName = "Testcase";
    String email = "TestCase@Testcase.com";
    String homeAddress = "1 Test Lane";
    String phoneNumber = "83377778";
    String contractType = "casual";
    LocalDate startDate = LocalDate.of(2022, 4, 13);
    LocalDate endDate = LocalDate.of(2022, 4, 14);

    CreateEmployeeDto employee = new CreateEmployeeDto(
      firstName,
      middleName,
      lastName,
      email,
      homeAddress,
      phoneNumber,
      contractType,
      startDate,
      endDate
    );

    mockMvc
      .perform(
        post("/employees")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(employee))
      )
      .andExpect(status().isCreated())
      .andReturn();
  }

  //delete and get all work
  @Test
  public void itShouldReturnEmptyAfterDeletingAllEmployees() throws Exception {
    mockMvc.perform(delete("/employees")).andExpect(status().isNoContent());

    mockMvc
      .perform(MockMvcRequestBuilders.get("/employees"))
      .andExpect(status().isOk())
      .andExpect(content().json("[]"));
  }

  @Test
  public void itShouldGetOneEmployeeByID() throws Exception {
    Employee mockEmployee = new Employee();

    mockEmployee.setId(1L);
    mockEmployee.setFirstName("Little");
    mockEmployee.setMiddleName("Johnny");
    mockEmployee.setLastName("Tester");
    mockEmployee.setEmail("LittleJohnny@gmail.com");
    mockEmployee.setHomeAddress("1 Test Street");
    mockEmployee.setPhoneNumber("555555555");
    mockEmployee.setContractType("Casual");

    mockEmployee.setStartDate(LocalDate.of(2022, 4, 13));
    mockEmployee.setEndDate(LocalDate.of(2022, 4, 14));

    when(employeeService.findById(1L)).thenReturn(Optional.of(mockEmployee));

    mockMvc
      .perform(MockMvcRequestBuilders.get("/employees/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.firstName").value("Little"))
      .andExpect(jsonPath("$.contractType").value("Casual"));
  }

  @Test
  public void itShouldDeleteByIdAndReturnOkIfEmployeeExists() throws Exception {
    Employee mockEmployee = new Employee();
    mockEmployee.setId(1L);
    mockEmployee.setFirstName("Little");
    mockEmployee.setMiddleName("Johnny");
    mockEmployee.setLastName("Tester");
    mockEmployee.setEmail("LittleJohnny@gmail.com");
    mockEmployee.setHomeAddress("1 Test Street");
    mockEmployee.setPhoneNumber("555555555");
    mockEmployee.setContractType("Casual");
    mockEmployee.setStartDate(LocalDate.of(2022, 4, 13));
    mockEmployee.setEndDate(LocalDate.of(2022, 4, 14));

    Long id = 1L;

    when(employeeService.findById(id)).thenReturn(Optional.of(mockEmployee));

    mockMvc
      .perform(delete("/employees/{id}", id))
      .andExpect(status().isNoContent());
    verify(employeeService, times(1)).deleteEmployeeById(id);
  }

  @Test
  public void itShouldreturnInvalidIfDeletingEmployeeDoesNotExist()
    throws Exception {
    Long id = 2L;

    when(employeeService.findById(id)).thenReturn(Optional.empty());

    mockMvc
      .perform(delete("/employees/{id}", id))
      .andExpect(status().isNotFound());
    verify(employeeService, times(0)).deleteEmployeeById(id);
  }
}
