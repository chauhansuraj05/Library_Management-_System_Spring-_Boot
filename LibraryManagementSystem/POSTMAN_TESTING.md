# Library Management System - Postman Testing

Base URL: `http://localhost:8080`

## 1. Register
POST `/api/auth/register`
```json
{"name":"Suraj","email":"suraj@gmail.com","password":"1234"}
```

## 2. Login
POST `/api/auth/login`
```json
{"email":"suraj@gmail.com","password":"1234"}
```
Expected: `Login successful. User ID: 1`

## 3. Add Book
POST `/api/books`
```json
{"title":"Java Programming","author":"James Gosling","isbn":"ISBN-1001","category":"Programming","quantity":3}
```

Add another:
```json
{"title":"Spring Boot in Action","author":"Craig Walls","isbn":"ISBN-1002","category":"Spring","quantity":2}
```

## 4. Get All Books
GET `/api/books`

## 5. Get Book By ID
GET `/api/books/1`

## 6. Update Book
PUT `/api/books/1`
```json
{"title":"Core Java Programming","author":"James Gosling","isbn":"ISBN-1001","category":"Java","quantity":5}
```

## 7. Borrow Book
POST `/api/library/borrow/user/1/book/1`
Expected: availableQuantity decreases by 1.

## 8. See User Borrow History
GET `/api/library/user/1`

## 9. See All Borrow Records
GET `/api/library/records`

## 10. Return Book
PUT `/api/library/return/1`
Expected: status becomes RETURNED and availableQuantity increases by 1.

## 11. Delete Book
DELETE `/api/books/1`

### Recommended Postman order
Register -> Login -> Add Books -> Get Books -> Borrow -> Check User History -> Return -> Check Books.

### Important
This project follows the uploaded employee-system style: simple register/login, JPA entities, repositories, services and REST controllers. It does NOT use JWT/Spring Security. Passwords are stored as plain text in this learning example; for a real application, use password hashing and authentication/authorization.
