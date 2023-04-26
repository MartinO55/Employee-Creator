import React from "react";
import axios from "axios";
import { useQuery } from "react-query";
import { backendAddress } from "../config/backendConfig";
import Employee from "../types/Employee";

async function fetchAllEmployees(): Promise<Employee[]> {
  try {
    const response = await fetch(backendAddress + "employees");
    const data = await response.json();
    return data;
  } catch (error) {
    throw new Error("Failed to Fetch Employee Data");
  }
}
export default fetchAllEmployees;
