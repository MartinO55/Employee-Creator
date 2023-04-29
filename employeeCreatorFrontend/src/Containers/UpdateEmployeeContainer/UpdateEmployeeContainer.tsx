import React, { useEffect, useState } from "react";
import styles from "./UpdateEmployeeContainer.module.scss";
import UpdateEmployeeForm from "../../components/UpdateEmployeeForm/UpdateEmployeeForm";
import Employee from "../../types/Employee";
import { useParams } from "react-router-dom";
import fetchAllEmployees from "../../services/fetchAllEmployees";

const UpdateEmployeeContainer = () => {
  //so this component is called with an ID
  const { id } = useParams<{ id: string }>();

  const [employeeList, setEmployeeList] = useState<Employee[]>([]);
  //should have its own service
  function getEmployeeById(id: string) {
    if (id != undefined) {
      useEffect(() => {
        const getEmployees = async () => {
          const data = await fetchAllEmployees();
          setEmployeeList(data);
        };

        getEmployees();
      }, []);

      return employeeList.find((employee) => employee.id == id);
    } else throw new Error("could not find employee with id" + id);
  }

  const employee: Employee | undefined = id ? getEmployeeById(id) : undefined;

  return (
    <>
      <div>{employee && <UpdateEmployeeForm employee={employee} />}</div>
    </>
  );
};

export default UpdateEmployeeContainer;
