# Quiz Application

This is a Spring Boot-based backend application for managing quizzes and questions. The API allows users to create, retrieve, update, and delete questions and quizzes, and also to participate in quizzes by submitting their answers.

---

## 📚 Features

- CRUD operations for quiz questions
- Create custom quizzes based on category and number of questions
- Submit quizzes and get evaluated results

---

## 🧠 Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Git & GitHub

---

## 📁 Project Structure
src/
└── main/
├── java/
│ └── com.example.quiz
│ ├── controller
│ ├── model
│ ├── repository
│ └── service
└── resources/
└── application.properties

---

## 🔌 REST API Endpoints

### 📄 Question APIs

| Method | Endpoint                                   | Description                    |
|--------|--------------------------------------------|--------------------------------|
| GET    | `/api/question/allQuestions`               | Get all questions              |
| POST   | `/api/question/addQuestion`                | Add a new question             |
| PUT    | `/api/question/updateQuestion/{id}`        | Update an existing question    |
| DELETE | `/api/question/deleteQuestion/{id}`        | Delete a question              |
| GET    | `/api/question/category/{category}`        | Get questions by category      |

---

### 📝 Quiz APIs

| Method | Endpoint                                                                 | Description                     |
|--------|--------------------------------------------------------------------------|---------------------------------|
| POST   | `/api/quiz/createQuiz?noOfQuestions={value}&quizTitle={value}`           | Create a new quiz               |
| GET    | `/api/quiz/getQuiz/{id}`                                                 | Get quiz questions by ID        |
| POST   | `/api/quiz/submit/{id}`                                                  | Submit a quiz and get results   |

---

## ✅ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/saikrishna630/QuizApplication.git
Open the project in IntelliJ or Eclipse.

Configure your database in application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

🙌 Author
Pabbu Sai Krishna
GitHub
