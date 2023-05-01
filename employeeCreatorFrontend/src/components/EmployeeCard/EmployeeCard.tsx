import React from "react";
import styles from "./EmployeeCard.module.scss";
import Employee from "../../types/Employee";
import UpdateEmployeeContainer from "../../Containers/UpdateEmployeeContainer/UpdateEmployeeContainer";
import UpdateEmployeeForm from "../UpdateEmployeeForm/UpdateEmployeeForm";
import { useNavigate } from "react-router-dom";

type EmployeeCardProps = {
  employee: Employee;
  handleDelete: (id: string) => void;
};

const EmployeeCard = ({ employee, handleDelete }: EmployeeCardProps) => {
  const navigate = useNavigate();

  const handleEditNavigate = () => {
    navigate(`/UpdateEmployee/${employee.id}`);
  };

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
          <div>End Date: {employee.endDate}</div>
        </div>

        <button
          onClick={() => handleDelete(employee.id)}
          className={styles.card__DeleteEmployeeButton}
        >
          Delete Employee
        </button>
        <button
          onClick={handleEditNavigate}
          className={styles.card__EditEmployeeButton}
        >
          Edit Employee
        </button>
      </div>
    </>
  );
};

export default EmployeeCard;
