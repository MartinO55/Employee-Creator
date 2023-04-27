import React from "react";
import Header from "./components/Header/Header";
import EmployeeListContainer from "./Containers/EmployeeListContainer/EmployeeListContainer";
import HomePage from "./Containers/HomePage/HomePage";
import Footer from "./components/Footer/Footer";
import NotFound from "./components/NotFound/NotFound";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CreateEmployeeForm from "./components/CreateEmployeeForm/CreateEmployeeForm";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="*" element={<NotFound />} />
          <Route path="/employees" element={<EmployeeListContainer />} />
          <Route path="/NewEmployee" element={<CreateEmployeeForm />} />
        </Routes>

        <Footer></Footer>
      </BrowserRouter>
    </>
  );
};

export default App;
