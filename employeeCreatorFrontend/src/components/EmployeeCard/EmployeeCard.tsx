import React from "react";
import styles from "./EmployeeCard.module.scss";
import Employee from "../../types/Employee";

type EmployeeCardProps = { employee: Employee };

const EmployeeCard = ({ employee }: EmployeeCardProps) => {
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
      </div>
    </>
  );
};

export default EmployeeCard;
