import React from "react";
import styles from "./NavBar.module.scss";
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <>
      <div className={styles.NavBar}>
        <ul className={styles.NavbarLinks}>
          <li className={styles.NavbarLinks__ALink}>
            <Link to="/">Home</Link>
          </li>
          <li className={styles.NavbarLinks__ALink}>
            <Link to="/NewEmployee">Add an Employee</Link>
          </li>
        </ul>
      </div>
    </>
  );
};

export default NavBar;
