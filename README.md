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

Enjoy using Quiz Maker!
