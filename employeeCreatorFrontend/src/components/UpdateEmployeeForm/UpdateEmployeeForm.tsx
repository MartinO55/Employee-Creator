import React from "react";
import styles from "./UpdateEmployeeForm.module.scss";
import { useParams } from "react-router-dom";
import Employee from "../../types/Employee";

type UpdatepageProps = {
  employeeList?: Employee[];
};

const UpdateEmployeeForm = ({ employeeList }: UpdatepageProps) => {
  const { id } = useParams();

  const getEmployee = () => {
    if (employeeList) {
      return employeeList.find((employee) => employee.id == id);
    }
  };

  return (
    <>
      <div></div>
    </>
  );
};

export default UpdateEmployeeForm;
