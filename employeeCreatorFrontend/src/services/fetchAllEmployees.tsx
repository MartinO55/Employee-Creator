import React from "react";
import axios from "axios";
import { useQuery } from "react-query";
import { backendAddress } from "../config/backendConfig";

const fetchAllEmployees = () => {
  try {
    return useQuery("getEmployees", async () => {
      const result = await axios.get(backendAddress);
      return result.data;
    });
  } catch (error) {
    console.log(error);
    return error;
  }
};

export default fetchAllEmployees;
