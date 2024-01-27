import React from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./index.css";

const Header = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const handleHeaderClick = () => {
    if (location.pathname.includes("/quiz/") == false) {
      navigate("/");
      return;
    }
    const leaveQuiz = window.confirm(
      "Are you sure you want to leave? Your progress will be lost."
    );
    if (leaveQuiz) {
      navigate("/");
    }
  };

  return (
    <div className="bg-blue-500 text-white p-4 mb-8 ">
      <div className="container mx-auto flex justify-between items-center">
        <span 
          className="text-xl font-bold cursor-pointer"
          onClick={handleHeaderClick}
        >
          Quiz App
        </span>
      </div>
    </div>
  );
};

export default Header;
