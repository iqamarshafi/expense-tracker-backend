# Personal Expense Log - Spring Boot Backend

A Spring Boot RESTful API backend service that handles business logic and persistent storage for the Personal Expense Log application.

## API Endpoints
| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/expenses` | Fetches all recorded expenses ordered by date (latest first) |
| `POST` | `/api/v1/expenses` | Saves a new expense item to the database |
| `DELETE` | `/api/v1/expenses/{id}` | Deletes an expense record by its primary key ID |

## Tech Stack
- **Language:** Java 25
- **Framework:** Spring Boot v4.2
- **Database:** MySQL (`expense_db`)
- **ORM / Persistence:** Spring Data JPA / Hibernate
- **Server:** Embedded Apache Tomcat (Port 8081)

## How to Run Locally

### Prerequisites
- JDK 25 installed
- MySQL Server running locally on port 3306

### Database Setup
1. Create a MySQL database named `expense_db`:
   ```sql
   CREATE DATABASE expense_db;e named `expense_db`:
   ```sql
   CREATE DATABASE expense_db;
