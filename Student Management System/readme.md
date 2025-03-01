# 🏫 Student Management System

A **Student Management System (SMS)** built using **Spring Boot** that allows administrators to manage student records efficiently.

---

## 🚀 Features

✅ Add, update, and delete student records  
✅ View a list of all students   
✅ Database integration  
✅ Spring Boot MVC architecture  

---

## 🛠️ Technologies Used

- **Spring Boot** (Backend Framework)
- **Spring Data JPA** (Database Access)
- **PostgreSQL** (Relational Database)
- **Thymeleaf** (For UI if applicable)
- **Maven** (Dependency Management)

---

## 📁 Folder Structure

<pre>
Student Management System
│── src
│   ├── main
│   │   ├── java/com/example/sms/sms
│   │   │   ├── controller/             # Handles API requests
│   │   │   ├── entity/                 # Student Entity
│   │   │   ├── repository/             # Data Access Layer
│   │   │   ├── service/                # Business Logic
│   │   ├── resources/
│   │   │   ├── application.properties  # Configurations
│   │   │   ├── templates               # Frontend
│   │   │   │   ├── HTMLs
│── pom.xml                             # Maven Dependencies
│── README.md
</pre>

---

## 📌 API Endpoints


| HTTP Method | Endpoint             | Description                  |
|------------|----------------------|------------------------------|
| **GET**    | `/students`           | Get all students             |
| **GET**    | `/students/add`       | Add Student Form             |
| **POST**   | `/students`           | Add a new student            |
| **GET**    | `/students/edit/{id}` | Edit Student Form By ID      |
| **POST**   | `/students/{id}`      | Update student details by ID |
| **GET**    | `/students/{id}`      | Delete a student by ID       |
