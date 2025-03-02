# 🏫 Student Management System

A **Student Management System (SMS)** built using **Spring Boot** that allows administrators to manage student records efficiently.

---

## 🚀 Features

✅ Add, update, and delete student records  
✅ View a list of all students   
✅ Database integration  
✅ Spring Boot MVC architecture  

---

## 🎨 Demo

**View a list of students**

![image](https://github.com/user-attachments/assets/46b1b7d5-d732-49f4-86dd-82d85adc34d6)

##
**Add a student record**

![image](https://github.com/user-attachments/assets/1b54a5df-cdb4-46dd-b1a6-adeb01cc356a)

![image](https://github.com/user-attachments/assets/b15b374a-35f4-482e-a379-76efac9b3041)

##
**Update a student record**

![image](https://github.com/user-attachments/assets/ff877c3e-f079-4d15-8673-09fe379b830c)

![image](https://github.com/user-attachments/assets/c60fd28a-33d5-43cc-a0ad-514947b98ea3)

##
**Delete a student record**

![image](https://github.com/user-attachments/assets/7da464e6-7272-4e68-9b3d-804b27ff1bf9)

##
**Database Integration**

![image](https://github.com/user-attachments/assets/b1d11f9e-7a05-4bd0-9e0c-c03de50f3179)


---

## 🛠️ Technologies Used

- **Spring Boot** (Backend Framework)
- **Spring Data JPA** (Database Access)
- **PostgreSQL** (Relational Database)
- **Thymeleaf** (For UI if applicable)
- **Maven** (Dependency Management)

---

## 📁 Project Structure

<pre>
Student Management System
│── src
│   ├── main
│   │   ├── java/com/example/sms/sms
│   │   │   ├── controller/             # Handles API requests
│   │   │   ├── entity/                 # Student Entity
│   │   │   ├── repository/             # Data Access Layer
│   │   │   ├── service/                # Business Logic
│   │   │   │   ├── impl/               # Business Logic Implementation   
│   │   ├── resources/
│   │   │   ├── application.properties  # Configurations
│   │   │   ├── templates               # Frontend
│   │   │   │   ├── HTMLs
│── pom.xml                             # Maven Dependencies
│── README.md
</pre>

---

## 📌 Endpoints


| HTTP Method | Endpoint             | Description                  |
|------------|----------------------|------------------------------|
| **GET**    | `/students`           | Get all students             |
| **GET**    | `/students/add`       | Add Student Form             |
| **POST**   | `/students`           | Add a new student            |
| **GET**    | `/students/edit/{id}` | Edit Student Form By ID      |
| **POST**   | `/students/{id}`      | Update student details by ID |
| **GET**    | `/students/{id}`      | Delete a student by ID       |
