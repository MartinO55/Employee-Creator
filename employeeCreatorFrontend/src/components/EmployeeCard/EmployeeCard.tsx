import React from "react";
import styles from "./EmployeeCard.module.scss";
import Employee from "../../types/Employee";

type EmployeeCardProps = {
  employee: Employee;
  handleDelete: (id: string) => void;
};

const EmployeeCard = ({ employee, handleDelete }: EmployeeCardProps) => {
  return (
    <>
      <div className={styles.card}>
        <div className={styles.card__employeeName}>
          {employee.firstName} {employee.middleName} {employee.lastName}
        </div>
        <div className={styles.card__employeeContactDetails}>
          <div>{employee.email}</div>
          <div>{employee.phoneNumber}</div>
        </div>
        <div className={styles.card__employeeContractDetails}>
          <div>{employee.contractType}</div>
          <div>Start Date: {employee.startDate}</div>
          <div>{employee.endDate}</div>
        </div>

        <button onClick={() => handleDelete(employee.id)}>
          Delete Employee
        </button>
        <button>Edit Employee</button>
      </div>
    </>
  );
};

export default EmployeeCard;
