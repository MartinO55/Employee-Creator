package com.martin.employeecreator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.martin.employeecreator.Employee.CreateEmployeeDto;
import com.martin.employeecreator.Employee.EmployeeService;
import com.martin.employeecreator.Employee.EmployeecreatorApplication;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class EmployeecreatorApplicationTests {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private EmployeeService employeeService;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  //get All works
  @Test
  public void testTest() throws Exception {
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
  public void createValidEmployeeTest() throws Exception {
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
  public void DeleteAllEmployeesTest() throws Exception {
    mockMvc.perform(delete("/employees")).andExpect(status().isNoContent());

    mockMvc
      .perform(MockMvcRequestBuilders.get("/employees"))
      .andExpect(status().isOk())
      .andExpect(content().json("[]"));
  }
}
