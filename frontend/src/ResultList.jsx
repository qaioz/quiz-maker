import React, { useState, useEffect } from "react";
import axios from "axios";
import { GoSidebarCollapse } from "react-icons/go";
import {REACT_APP_BACKEND_URL} from "./App";

const ResultList = ({ quizId }) => {
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(true);
  const [isOpen, setOpen] = useState(false);

  useEffect(() => {
    const fetchResults = async () => {
      try {
        const response = await axios.get(
          `${REACT_APP_BACKEND_URL}/api/v1/quiz/${quizId}/quizresults`
        );

        setResults(response.data);
        setLoading(false);
      } catch (error) {
        console.error("Error fetching results:", error);
        setLoading(false);
      }
    };

    fetchResults();
  }, [quizId]);

  if (loading) {
    return <p>Loading results...</p>;
  }

  let resultList = results.map((result) => (
    <div key={result.quizResultId} className="p-4 border-2">
      <p className="font-semibold text-blue-500">Nickname: {result.nickname}</p>
      <p>Score: {result.score}</p>
      <p>Finished At: {new Date(result.finishedAt).toLocaleString()}</p>
    </div>
  ));

  return (
    <div className="flex flex-row-reverse ">
      
      <div
        className={`max-h-screen overflow-scroll scrollbar-thin scrollbar-thumb-blue-500 scrollbar-track-gray-200  ${
          isOpen ? "w-72" : "w-0"
        } duration-300`}
      >
        <GoSidebarCollapse
          className={`text-blue-900 cursor-pointer text-4xl absolute right-0.5 ${
            !isOpen && "rotate-180"
          }`}
          onClick={() => setOpen(!isOpen)}
        />
        <span className="text-2xl text-blue-900 p-4">Results</span>
        <div className="overflow-y-auto">
            {resultList}
        </div>
      </div>
    </div>
  );
};

export default ResultList;
