import React from "react";

const DeleteButton = ({  onDelete }) => {

  return (
    <button
      className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded ml-4"
      onClick={onDelete}
    >
      Delete
    </button>
  );
};

export default DeleteButton;
