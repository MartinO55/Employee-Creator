import React, { useEffect, useState } from "react";
import styles from "./EmployeeListContainer.module.scss";
import EmployeeCard from "../../components/EmployeeCard/EmployeeCard";

type Employee = {
  id: string;
  firstName: string;
  middleName: string | null;
  lastName: string;
  email: string;
  phoneNumber: string;
  contractType: string;
  createdAt: string;
  startDate: string;
  endDate: string | null;
};

async function fetchAllEmployees(): Promise<Employee[]> {
  const response = await fetch("http://localhost:8080/employees");
  const data = await response.json();
  return data;
}

const EmployeeListContainer = () => {
  const [employeeList, setEmployeeList] = useState<Employee[]>([]);

  useEffect(() => {
    const getEmployees = async () => {
      const data = await fetchAllEmployees();
      setEmployeeList(data);
    };

    getEmployees();
  }, []);

  return (
    <>
      <div>
        <div>Employees: </div>
        {employeeList.map((employee) => (
          <li>
            <EmployeeCard employee={employee} />
          </li>
        ))}
      </div>
    </>
  );
};

export default EmployeeListContainer;
