import React from "react";
import styles from "./CreateEmployeeForm.module.scss";

const CreateEmployeeForm = () => {
  return (
    <>
      <div>
        <form>
          <div>
            <input type="text" placeholder="First Name" />
          </div>
          <div>
            <input type="text" placeholder="Middle Name" />
          </div>
          <div>
            <input type="text" placeholder="last Name" />
          </div>

          <div>
            <input type="text" placeholder="email" />
          </div>
          <div>
            <input type="text" placeholder="phone number" />
          </div>

          <div>
            <input type="text" placeholder="Contract Type" />
          </div>
          <div>
            <input type="text" placeholder="start Date" />
          </div>
          <div>
            <input type="text" placeholder="end date" />
          </div>
        </form>
      </div>
    </>
  );
};

export default CreateEmployeeForm;
