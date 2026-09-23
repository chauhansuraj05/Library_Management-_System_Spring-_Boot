# 📚 Library Management System

A Spring Boot based Library Management System with REST APIs for managing users, books, borrowing and returning books.

## 🚀 Features

- User Registration & Login
- Add, Update, Delete & View Books
- Borrow & Return Books
- Borrowing History
- Book Quantity Management
- REST API Testing with Postman

## 🛠️ Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## 🏗️ Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
````

## 🔗 Main APIs

```text
POST   /api/auth/register
POST   /api/auth/login

POST   /api/books
GET    /api/books
GET    /api/books/{id}
PUT    /api/books/{id}
DELETE /api/books/{id}

POST   /api/library/borrow/user/{userId}/book/{bookId}
GET    /api/library/user/{userId}
GET    /api/library/records
PUT    /api/library/return/{recordId}
```

## 🧪 Testing

All APIs were tested successfully using Postman with `200 OK` and `201 Created` responses.

## 👨‍💻 Author

**Suraj Chauhan**

Java | Spring Boot | REST API | JPA | MySQL

````

````
