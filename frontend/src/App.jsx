import React, { useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, Link, useNavigate, useLocation } from "react-router-dom";
import Home from "./Home";
import "./index.css";
import Quiz from "./Quiz";
import QuizCreation from "./QuizCreation";
import Header from "./Header";
const REACT_APP_BACKEND_URL = "http://localhost:8080";
export { REACT_APP_BACKEND_URL };
function App() {
  return (
    <>
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/quiz/:id" element={<Quiz />} />
          <Route path="/create" element={<QuizCreation />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
