import React from "react";
import Header from "./components/Header/Header";
import EmployeeListContainer from "./Containers/EmployeeListContainer/EmployeeListContainer";
import HomePage from "./Containers/HomePage/HomePage";
import Footer from "./components/Footer/Footer";
import NotFound from "./components/NotFound/NotFound";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import CreateEmployeeForm from "./components/CreateEmployeeForm/CreateEmployeeForm";
import UpdateEmployeeContainer from "./Containers/UpdateEmployeeContainer/UpdateEmployeeContainer";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="*" element={<NotFound />} />
          <Route path="/NewEmployee" element={<CreateEmployeeForm />} />

          <Route path="/" element={<EmployeeListContainer />} />
          <Route
            path="/UpdateEmployee/:id"
            element={<UpdateEmployeeContainer />}
          />
        </Routes>

        <Footer></Footer>
      </BrowserRouter>
    </>
  );
};

export default App;
