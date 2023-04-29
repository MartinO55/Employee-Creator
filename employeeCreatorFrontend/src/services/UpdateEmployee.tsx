import { backendAddress } from "../config/backendConfig";
import Employee from "../types/Employee";

export async function UpdateEmployee(updatedEmployee: Employee) {
  try {
    await fetch(backendAddress + `employees/${updatedEmployee.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedEmployee),
    });
  } catch (error) {
    console.log(error);
    throw new Error("unable to update Employee");
  }
}
