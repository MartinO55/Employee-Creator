import Employee from "../types/Employee";
import { backendAddress } from "../config/backendConfig";
import { CreateNewEmployee } from "../types/CreateNewEmployee";

export async function CreateNewEmployee(newEmployee: CreateNewEmployee) {
  try {
    await fetch(backendAddress + "employees", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newEmployee),
    });
  } catch (error) {
    throw new Error("Could Not Create new Employee");
  }
}
