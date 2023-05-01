import React, { useState } from "react";
import styles from "./CreateEmployeeForm.module.scss";

import { backendAddress } from "../../config/backendConfig";

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

    fetch(backendAddress + "employees", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formValues),
    });
    //needs to navigate to the employees list
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
              required
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
              required
            />
          </div>

          <div>
            <input
              type="text"
              placeholder="email"
              name="email"
              value={formValues.email}
              onChange={handleInput}
              required
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="phone number"
              name="phoneNumber"
              value={formValues.phoneNumber}
              onChange={handleInput}
              required
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="Home Address"
              name="homeAddress"
              value={formValues.homeAddress}
              onChange={handleInput}
              required
            />
          </div>

          <div>
            <input
              type="text"
              placeholder="Contract Type"
              name="contractType"
              value={formValues.contractType}
              onChange={handleInput}
              required
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="start Date"
              name="startDate"
              value={formValues.startDate}
              onChange={handleInput}
              required
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
