import React from "react";
import styles from "./EmployeeCard.module.scss";
import Employee from "../../types/Employee";

type EmployeeCardProps = { employee: Employee };

const EmployeeCard = ({ employee }: EmployeeCardProps) => {
  return (
    <>
      <div>{employee.firstName}</div>
    </>
  );
};

export default EmployeeCard;
