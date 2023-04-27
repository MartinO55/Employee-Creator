import React, { useState } from "react";
import styles from "./CreateEmployeeForm.module.scss";

import Employee from "../../types/Employee";
import { backendAddress } from "../../config/backendConfig";
import { CreateNewEmployee } from "../../services/createNewEmployee";

interface FormValues {
  firstName: string;
  middleName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  homeAddress: string;
  contractType: string;
  startDate: string;
  endDate: string;
}

const CreateEmployeeForm = () => {
  const [formValues, setFormValues] = useState<FormValues>({
    firstName: "",
    middleName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    homeAddress: "",
    contractType: "",
    startDate: "",
    endDate: "",
  });

  const handleInput = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormValues((prevValues) => ({ ...prevValues, [name]: value }));
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log("submitted" + formValues.firstName);
    fetch(backendAddress + "employees", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formValues),
    });
  };

  return (
    <>
      <div>
        <form onSubmit={handleSubmit}>
          <div>
            <input
              type="text"
              placeholder="First Name"
              name="firstName"
              value={formValues.firstName}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="Middle Name"
              name="middleName"
              value={formValues.middleName}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="last Name"
              name="lastName"
              value={formValues.lastName}
              onChange={handleInput}
            />
          </div>

          <div>
            <input
              type="text"
              placeholder="email"
              name="email"
              value={formValues.email}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="phone number"
              name="phoneNumber"
              value={formValues.phoneNumber}
              onChange={handleInput}
            />
            <input
              type="text"
              placeholder="Home Address"
              name="homeAddress"
              value={formValues.homeAddress}
              onChange={handleInput}
            />
          </div>

          <div>
            <input
              type="text"
              placeholder="Contract Type"
              name="contractType"
              value={formValues.contractType}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="start Date"
              name="startDate"
              value={formValues.startDate}
              onChange={handleInput}
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="end date"
              name="endDate"
              value={formValues.endDate}
              onChange={handleInput}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    </>
  );
};

export default CreateEmployeeForm;
