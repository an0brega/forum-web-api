# 🧵 Forum API

A RESTful API built with **Java + Spring Boot** to manage topics in a discussion forum.  
This is a backend project following clean architecture principles, including DTOs, Forms, Repositories, and Controllers.

---

 ## 📚 Reference

Inspired and based on the course [Spring Boot API REST](https://cursos.alura.com.br/course/spring-boot-api-rest) from Alura.

---

## 📁 Project Structure

```bash
src/
├── main/
│ ├── java/br/com/alura/forum/
│ │ ├── controller/ # Handles HTTP requests
│ │ │ ├── dto/ # Data Transfer Objects
│ │ │ └── form/ # Request form objects (for creating/updating resources)
│ │ ├── enums/ # Enum types (e.g., status, categories)
│ │ ├── modelo/ # Domain models (e.g., Topic, User)
│ │ └── repository/ # Spring Data JPA interfaces
│ └── resources/
│ ├── static/ # Static assets (if any)
│ └── templates/ # Thymeleaf templates (if used)
└── test/
└── java/br/com/alura/forum/ # Unit and integration tests
```

---

## 🚀 Technologies

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://docs.oracle.com/en/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![H2 Database](https://img.shields.io/badge/H2-1A73E8?style=flat-square&logo=h2&logoColor=white)](https://www.h2database.com/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=postman&logoColor=white)](https://www.postman.com/)
[![Lombok](https://img.shields.io/badge/Lombok-A51C30?style=flat-square&logo=java&logoColor=white)](https://projectlombok.org/)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)


## 📌 Features

- ✅ List all topics
- ✅ Get topic by ID
- ✅ Create a new topic
- ✅ Update topic information
- ✅ Delete a topic
- ✅ Input validation and DTO mapping
- ✅ Global error handling

---

## 📫 API Endpoints (Some to be implemented)

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| GET    | `/topics`            | List all topics         |
| GET    | `/topics/{id}`       | Get topic by ID         |
| POST   | `/topics`            | Create new topic        |
| PUT    | `/topics/{id}`       | Update existing topic   |
| DELETE | `/topics/{id}`       | Delete topic by ID      |

---

## 🧪 Test

[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=postman&logoColor=white)](https://www.postman.com/)


---

## To be added:
- Change the implementation from the H2 database to the PostgreSQL.

---
