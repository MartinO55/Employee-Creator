import React from "react";
import Header from "./components/Header/Header";
import EmployeeListContainer from "./components/EmployeeListContainer/EmployeeListContainer";
import Footer from "./components/Footer/Footer";

const App = () => {
  return (
    <>
      <Header></Header>
      <EmployeeListContainer></EmployeeListContainer>
      <Footer></Footer>
    </>
  );
};

export default App;
