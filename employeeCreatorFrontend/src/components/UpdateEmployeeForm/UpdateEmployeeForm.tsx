import React, { FormEvent, useState } from "react";
import styles from "./UpdateEmployeeForm.module.scss";

import Employee from "../../types/Employee";
import { UpdateEmployee } from "../../services/UpdateEmployee";

interface UpdateEmployeeProps {
  employee: Employee;
}

const UpdateEmployeeForm: React.FC<UpdateEmployeeProps> = ({ employee }) => {
  console.log(employee);
  const [formData, setFormData] = useState<Employee>({
    id: employee.id,
    firstName: employee.firstName,
    middleName: employee.middleName,
    lastName: employee.lastName,
    email: employee.email,
    phoneNumber: employee.phoneNumber,
    homeAddress: employee.homeAddress,
    contractType: employee.contractType,
    startDate: employee.startDate,
    endDate: employee.endDate,
    createdAt: employee.createdAt,
  });

  const handleInput = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;

    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  function handleSubmit(event: FormEvent<HTMLFormElement>): void {
    event.preventDefault();
    //send data
    console.log(formData);
    UpdateEmployee(formData);
  }

  return (
    <>
      <div>
        <form onSubmit={handleSubmit}>
          <div>
            <input
              type="text"
              placeholder="First Name"
              name="firstName"
              value={formData.firstName}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="Middle Name"
              name="middleName"
              value={formData.middleName ?? ""}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="last Name"
              name="lastName"
              value={formData.lastName}
              onChange={handleInput}
            />
          </div>

          <div>
            <input
              type="text"
              placeholder="email"
              name="email"
              value={formData.email}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="phone number"
              name="phoneNumber"
              value={formData.phoneNumber}
              onChange={handleInput}
            />
            <input
              type="text"
              placeholder="Home Address"
              name="homeAddress"
              value={formData.homeAddress}
              onChange={handleInput}
            />
          </div>

          <div>
            <input
              type="text"
              placeholder="Contract Type"
              name="contractType"
              value={formData.contractType}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="start Date"
              name="startDate"
              value={formData.startDate}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="end date"
              name="endDate"
              value={formData.endDate ?? ""}
              onChange={handleInput}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    </>
  );
};

export default UpdateEmployeeForm;
