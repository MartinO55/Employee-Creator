import Employee from "../types/Employee";
import { backendAddress } from "../config/backendConfig";

export async function CreateNewEmployee(employee: Employee) {
  //   const newEmployee: Employee = {
  //     firstName: employee.firstName,
  //     middleName: employee.middleName,
  //     lastName: employee.lastName,
  //     email: employee.email,
  //     phoneNumber: employee.phoneNumber,
  //     contractType: employee.contractType,
  //     startDate: employee.startDate,
  //     endDate: employee.endDate,
  //   };
  try {
    const response = await fetch(backendAddress + "employees", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({}),
    });
  } catch (error) {
    throw new Error("Could Not Create new Employee");
  }
}
