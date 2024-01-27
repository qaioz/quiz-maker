import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {REACT_APP_BACKEND_URL} from "./App";

const QuizCreation = () => {
  const [questions, setQuestions] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [response, setResponse] = useState(null);
  const [error, setError] = useState(false);
  const [quizName, setQuizName] = useState("Untitled");
  const navigate = useNavigate(); 

  const createQuiz = async () => {
    setIsLoading(true);
    try {
      const response = await axios.post(`${REACT_APP_BACKEND_URL}/api/v1/quiz`, {
        questions: questions,
        title: quizName,
      });
      setResponse(response.data);
      setIsLoading(false);
      //if 201 then redirect to home page
      if (response.status === 201) {
        navigate("/"); // Navigate back to the home page
      }
    } catch (error) {
      setIsLoading(false);
      setError(true);
    }
  };

  return (
    <div className="w-4/5 mx-auto p-6 bg-white shadow-md rounded-md">
      <h2 className="text-2xl text-blue-900 font-bold mb-4">New Quiz</h2>
      <label className="block mb-2">
        <span className="text-gray-700">Quiz Name</span>
        <input
          className="w-full p-2 border border-gray-300 rounded-md"
          value={quizName}
          onChange={(e) => setQuizName(e.target.value)}
          placeholder="Enter quiz name here..."
        />
      </label>
      <textarea 
        className="w-full p-2 mb-4 border border-gray-300 rounded-md"
        value={questions}
        onChange={(e) => setQuestions(e.target.value)}
        placeholder={
`[Q] Who wrote the count of monte kristo?
yes,I live here, what;Alexandre Dumas*;Victor Hugo;Jules Verne;Gustave Flaubert
[Q] Who was the first president of Georgia?
Zviad Gamsakhurdia*;Bidzina Ivanishvili;Eduard Shevardnadze;Misha;Salome Zurabishvili`}
        rows={4}
        cols={50}
      />
      <button
        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        onClick={createQuiz}
        disabled={isLoading}
      >
        {isLoading ? "Loading..." : "Create Quiz"}
      </button>
      {response && <p className="mt-4 text-green-500">{response.data}</p>}
      {error &&
        (!response ? (
          <p className="mt-4 text-red-500">
            There was an error creating the quiz
          </p>
        ) : (
          <p className="mt-4">{response.data}</p>
        ))}
    </div>
  );
};

export default QuizCreation;
