# Expense Tracker API

A **RESTful API** built with **Spring Boot** to manage personal expenses efficiently. It supports adding, viewing, deleting expenses, and provides summaries by category.

## Features
- **CRUD operations** for expenses
- **Filter and sort** expenses by category or amount
- **Category-wise summaries** of total spending
- Built with **Spring Boot**, **JPA/Hibernate**, and **H2 in-memory database**

## Technologies
- Java 24
- Spring Boot 3.x
- JPA/Hibernate
- H2 Database

## API Endpoints
- `GET /api/expenses` – List all expenses, supports filtering and sorting
- `POST /api/expenses` – Add a new expense
- `DELETE /api/expenses/{id}` – Delete an expense
- `GET /api/expenses/summary` – Get category-wise total

## Running the Project
1. Clone the repository:  
   ```bash
   git clone https://github.com/adeeb-1890/Expense-Tracker-Api.git

2. Open in your IDE and run ExpenseTrackerApplication.java
3. Access H2 console at http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:testdb)

