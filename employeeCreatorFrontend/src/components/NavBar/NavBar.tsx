import React from "react";
import styles from "./NavBar.module.scss";
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <>
      <div>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/NewEmployee">Add an Employee</Link>
          </li>
        </ul>
      </div>
    </>
  );
};

export default NavBar;
