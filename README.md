# 🔐 Spring Boot JWT Auth API
A simple REST API built with Spring Boot that uses JWT for secure authentication and MySQL for data storage.

## ✨ Features
* JWT-based login system
* Protected API endpoints
* MySQL database integration
* Clean layered structure

## 🛠 Tech Stack
* Java
* Spring Boot
* Spring Security
* JWT
* MySQL
* Maven

## 📁 Structure
```
src/
 ├── controller
 ├── service
 ├── repository
 ├── security
 └── model
```

## ⚙️ Setup
1. Clone the repo
2. Create MySQL DB:
   ```
   CREATE DATABASE jwt_demo;
   ```
3. Update `application.properties` with DB credentials
4. Run the app:
   ```
   mvn spring-boot:run
   ```

## 🔑 API
* **POST /api/login** → Get JWT token
* **GET /api/hello** → Access with token
<img width="1856" height="973" alt="Screenshot 2026-04-01 002257" src="https://github.com/user-attachments/assets/43522d90-89d2-490f-8323-5c2c47a0dcee" />
<img width="1808" height="1078" alt="Screenshot 2026-04-02 001035" src="https://github.com/user-attachments/assets/8477eaa7-a459-46ce-b533-75aafe59e2f3" />

## 🔄 Flow
Login → Token Generated → Send Token → Access Secured APIs

## Sc
