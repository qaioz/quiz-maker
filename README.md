# Quiz Maker

Quiz Maker is an application that allows you to create and manage quizzes. 

## Prerequisites

Before you begin, ensure you have met the following requirements:

- You have a **PostgreSQL server** installed on your machine.
- You have **Node.js** and **npm** installed on your machine.
- You have **Maven** installed on your machine.
- You have **Docker** installed on your machine (optional).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Starting the PostgreSQL Server

1. Start the PostgreSQL server with the username and password specified in `backend/src/application.properties`.
2. Create a database named `quiz_maker`.

### Starting the Backend

To start the backend, follow these steps:

1. Navigate to the `backend` directory:
    ```bash
    cd backend
    ```
2. Start the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```
3. Navigate back to the root directory:
    ```bash
    cd ..
    ```

### Starting the Frontend

To start the frontend, follow these steps:

1. Navigate to the `frontend` directory:
    ```bash
    cd frontend
    ```
2. Install the necessary packages:
    ```bash
    npm install
    ```
3. Start the application:
    ```bash
    npm start
    ```

## Using Docker

If you have Docker installed, you can use it to start the application:

1. Navigate to the `backend` directory:
    ```bash
    cd backend
    ```
2. Package the application:
    ```bash
    mvn clean package
    ```
3. Start the Docker containers:
    ```bash
    docker compose up
    ```

Then, connect to `localhost:3000` in your web browser.

# Functionality

## Homepage - Viewing Quizzes

![image](https://github.com/qaioz/quiz-maker/assets/100124448/3568d751-ee74-4a85-901e-4165097e5948)

Here, you can view all the quizzes available. Click on a quiz to start taking it. You can also remove quizzes by clicking ‘delete’. If you just thought that having this functionality on a website is a foolish idea, I agree, but I still don't like you.



## Creating Quiz with a Super Simple Format!

![image](https://github.com/qaioz/quiz-maker/assets/100124448/e879dd96-4ec1-4c15-b915-d60f1d549085)


You can specify the questions, the options, and the correct answer. 

## Taking Quiz

![image](https://github.com/qaioz/quiz-maker/assets/100124448/3e9808ac-bbcb-499c-94e2-8eade489dd62)


This is what it looks like when you're taking a quiz.

## Seeing Correct Answers

![image](https://github.com/qaioz/quiz-maker/assets/100124448/9caf4054-d75f-434b-8c9a-da082fc87f1e)


After completing a quiz, you can review the questions along with the correct answers.

## Viewing Submissions

![image](https://github.com/qaioz/quiz-maker/assets/100124448/157c5bab-a590-4aee-b7e0-286f0cbac379)


This is where you can view all your quiz submissions.


Enjoy using Quiz Maker!
