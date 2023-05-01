import React from "react";
import styles from "./Header.module.scss";
import NavBar from "../NavBar/NavBar";

const Header = () => {
  return (
    <>
      <div className={styles.NavBarHolder}>
        <NavBar></NavBar>
      </div>
    </>
  );
};

export default Header;
