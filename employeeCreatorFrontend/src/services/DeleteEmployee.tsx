import React from "react";
import Employee from "../types/Employee";
import { backendAddress } from "../config/backendConfig";

export async function deleteEmployee(id: string) {
  try {
    const response = await fetch(backendAddress + `employees/${id}`, {
      method: "DELETE",
    });

    console.log("delete Employee with id: " + id);
  } catch (error) {
    throw new Error("failed to Delete employee with id: " + id);
  }
}
