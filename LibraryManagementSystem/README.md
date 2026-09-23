# Library Management System

Spring Boot + JPA/Hibernate + MySQL REST API.

## Features
- User registration and login
- Add, view, update and delete books
- Borrow books
- Return books
- User borrowing history
- All borrowing records
- Automatic available-copy management

## Setup
1. Install Java 21, Maven and MySQL.
2. Open `src/main/resources/application.properties`.
3. Change `spring.datasource.password` to your MySQL password.
4. Run `LibraryManagementSystemApplication.java`.
5. Use Postman with the requests in `POSTMAN_TESTING.md`.

Database `library_db` is created automatically if the MySQL user has permission.
