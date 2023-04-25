import React from "react";
import axios from "axios";
import { useQuery } from "react-query";

const fetchAllEmployees = () => {
  try {
    return useQuery("getEmployees", async () => {
      const result = await axios.get("http://localhost:8080/employees");
      return result.data;
    });
  } catch (error) {
    console.log(error);
    return error;
  }
};

export default fetchAllEmployees;
