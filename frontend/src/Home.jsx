import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import DeleteButton from "./DeleteButton";
import {REACT_APP_BACKEND_URL} from "./App";
const Home = () => {
  const [quizzes, setQuizzes] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  let handleCreate = () => {
    navigate("/create");
  };

  let handQuizClick = (quiz) => {
    navigate("/quiz/" + quiz.quizId);
  };

  async function handleDelete(quizId) {
    try {
      await axios.delete(`${REACT_APP_BACKEND_URL}/api/v1/quiz/${quizId}`);
      setQuizzes(quizzes.filter((quiz) => quiz.quizId != quizId));
    } catch (error) {
      console.error("Error deleting quiz: ", error);
    }
  }

  useEffect(() => {
    axios
      .get(`${REACT_APP_BACKEND_URL}/api/v1/quiz`)
      .then((response) => {
        setQuizzes(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching data: ", error);
        setLoading(false);
      });
  }, []);
  if (loading) return "Loading...";

  return (
    <div className="mt-5">
      {quizzes.map((quiz) => (
        <div
          onClick={() => handQuizClick(quiz)}
          key={quiz.quizId}
          className="w-4/5 hover:cursor-pointer border border-gray-300 p-4 mb-4 rounded-md shadow-md mx-auto mt-2 flex justify-between items-center"
        >
          <div className="mb-2">
            <div className="mb-2">
              <strong className="text-lg text-blue-600">{quiz.title}</strong>
            </div>
            <div className="mb-2">
              <strong className="text-gray-600">Number of Questions:</strong>{" "}
              {quiz.questions.length}
            </div>
            <div className="text-gray-600">
              <strong>Uploaded:</strong>{" "}
              {quiz.createdAt.split(".")[0].replace("T", ",")}
            </div>
          </div>
          <DeleteButton
            quizId={quiz.quizId}
            onDelete={(e) => {
              e.stopPropagation();
              handleDelete(quiz.quizId);
            }}
          />
        </div>
      ))}
      <div className="flex">
        <button
          onClick={handleCreate}
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-3 px-6 rounded mx-auto text-xl"
        >
          Create New Quiz
        </button>
      </div>
    </div>
  );
};

export default Home;
