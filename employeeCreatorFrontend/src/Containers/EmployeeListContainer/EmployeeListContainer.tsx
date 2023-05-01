import React, { useEffect, useState } from "react";
import styles from "./EmployeeListContainer.module.scss";
import EmployeeCard from "../../components/EmployeeCard/EmployeeCard";
import Employee from "../../types/Employee";
import fetchAllEmployees from "../../services/fetchAllEmployees";
import { deleteEmployee } from "../../services/DeleteEmployee";

const EmployeeListContainer = () => {
  const [employeeList, setEmployeeList] = useState<Employee[]>([]);

  //placeholding
  const handleDelete = (id: string) => {
    deleteEmployee(id);
  };

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
        <h2>Employees: </h2>
        <ul className={styles.employee__Cards}>
          {employeeList.map((employee) => (
            <li key={employee.id}>
              <EmployeeCard employee={employee} handleDelete={handleDelete} />
            </li>
          ))}
        </ul>
      </div>
    </>
  );
};

export default EmployeeListContainer;
