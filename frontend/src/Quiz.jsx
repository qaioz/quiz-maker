import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import ResultList from "./ResultList";
import {REACT_APP_BACKEND_URL} from "./App";


// after submit button is clicked, the quiz goes in the state of showing the results
// all the coorect answers are shown in green, and the one that the user got wrong are shown in red, also
// submit button is now showing reset button, and the user can reset the quiz and start over,


function Quiz() {
  const { id } = useParams();
  const [quiz, setQuiz] = useState(null);
  const [selectedOptions, setSelectedOptions] = useState({});
  const [nickname, setNickname] = useState("");
  const [startedAt, setStartedAt] = useState(null);
  const [showingResults, setShowingResults] = useState(false);
  useEffect(() => {
    axios
      .get(`${REACT_APP_BACKEND_URL}/api/v1/quiz/${id}`)
      .then((response) => {
        setQuiz(response.data);
        setStartedAt(new Date().toISOString());
      })
      .catch((error) => {
        console.error("Error fetching quiz data: ", error);
      });
  }, [id]);

  useEffect(() => {
    const handleBeforeUnload = (event) => {
      const message = "Are you sure? Your progress will be lost.";
      event.returnValue = message;
      return message;
    };

    window.addEventListener("beforeunload", handleBeforeUnload);

    return () => {
      window.removeEventListener("beforeunload", handleBeforeUnload);
    };
  }, []);

  const isCorrect = (questionId, optionId) => {
    let question = null;
    quiz.questions.forEach((element) => {
      if (element.id == questionId) {
        question = element;
      }
    });
    let option = question.options.find((option) => option.id === optionId);
    return option.correct;
  };

  const handleOptionClick = (questionId, optionId) => {
    if (showingResults) {
      return;
    }
    if (selectedOptions[questionId] === optionId) {
      const newSelectedOptions = { ...selectedOptions };
      delete newSelectedOptions[questionId];
      setSelectedOptions(newSelectedOptions);
      return;
    }
    setSelectedOptions({
      ...selectedOptions,
      [questionId]: optionId,
    });
  };

  let handleSubmit = () => {

    if(showingResults){
      setNickname("");
      setSelectedOptions({});
      setShowingResults(false);
      return;
    }

    if (!nickname) {
      alert("Please enter your nickname");
      return;
    }
    if (Object.keys(selectedOptions).length !== quiz.questions.length) {
      alert("Please answer all questions");
      return;
    }

    let score = 0;
    for (let questionId in selectedOptions) {
      if (isCorrect(questionId, selectedOptions[questionId])) {
        score++;
      }
    }

    const quizResultInput = {
      nickname,
      score,
      startedAt: startedAt,
    };

    axios
      .post(
        `${REACT_APP_BACKEND_URL}/api/v1/quiz/${id}/quizresults`,
        quizResultInput,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        console.log("Quiz results submitted successfully:", response.data);

      })
      .catch((error) => {
        console.error("Error submitting quiz results:", error);
      });
    
    setShowingResults(true);
    console.log("Quiz results submitted successfully:");
    console.log(showingResults);
  };

  const bg_color_and_text_color = (questionId, optionId) => {
    if (showingResults) {
      if (isCorrect(questionId, optionId)) {
        return "bg-green-500 text-white";
      } else {
        if(selectedOptions[questionId] === optionId){
          return "bg-red-500 text-white";
        }else{
          return "";
        } 
      }
    } else {
      if (selectedOptions[questionId] === optionId) {
        return "bg-blue-500 text-white";
      } else {
        return "";
      }
    }
  };



  if (!quiz) return "Loading...";
  let questions = quiz.questions.map((question, qNumber) => {
    return (
      <div
        key={question.id}
        className="flex flex-col justify-center items-center p-2 rounded-md mx-2 my-2 border border-blue-500 text-bold shadow-md"
      >
        <h2 className="font-bold text-lg  text-blue-900">
          {qNumber + 1}. {question.content}
        </h2>
        {question.options.map((option) => {
          return (
            <div
              key={option.id}
              className={`font-medium w-full border border-black p-1 m-1 text-left rounded-md cursor-pointer ${selectedOptions[question.id] !== option.id && "hover:bg-gray-200"} ${bg_color_and_text_color(question.id, option.id)})}`}
              onClick={() => handleOptionClick(question.id, option.id)}
            >
              <h1>{option.content}</h1>
            </div>
          );
        })}
      </div>
    );
  });

  return (
    <div className="flex">
      <div className="flex w-3/4 mx-auto">
        <div className="flex-1 pr-8">
          {questions}
          <div className="flex flex-col items-center">
            <input
              className="mt-4 p-2 border border-blue-500 rounded-md cursor display-block w-3/5  "
              type="text"
              placeholder="Enter your nickname"
              value={nickname}
              onChange={(e) => setNickname(e.target.value)}
            />
            <button
              className="mt-4 p-2 bg-blue-500 text-white text-xl w-2/5 rounded-md cursor-pointer display-block"
              onClick={handleSubmit}
            >
              { showingResults ? "Reset" : "Submit"}
            </button>
          </div>
        </div>
      </div>
      <ResultList quizId={id}></ResultList>
    </div>
  );
}

export default Quiz;
