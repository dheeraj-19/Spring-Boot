# User Registration and Login System

This is a **User Registration and Login System** built using **Spring Boot, Spring Security, Hibernate (JPA), and PostgreSQL**. The application allows users to register, log in, and manage their authentication securely.

---

## 🚀 Features
- 🔒 **User Registration** with hashed passwords (BCrypt)
- ✅ **User Login & Authentication** using Spring Security
- 🛠 **Role-Based Authorization** (e.g., User, Admin)
- 📂 **Database Integration** with JPA/Hibernate
- 🎨 **Thymeleaf Templates** for frontend UI
- 🚀 **Spring Boot Security Configuration**
- 🏗 **Maven Project Structure**
- 📜 **MVC Architecture** (Controller, Service, Repository, Model)

---

## 🎨 Demo

🔒 **User Registration**

![image](https://github.com/user-attachments/assets/5bc1743c-0a17-49fc-aace-e5fe9a760c9e)

![image](https://github.com/user-attachments/assets/2f8388f3-17af-496c-aff5-b11c697f2a5d)

![image](https://github.com/user-attachments/assets/de546ec2-631d-4d20-be6d-af54c588f8ca)

## 
📂 **Database Integration**

![image](https://github.com/user-attachments/assets/e94b1148-38e7-461a-b747-9fdef6b75051)

## 
✅ **User Login & Authentication**

![image](https://github.com/user-attachments/assets/238e9315-d833-4e16-8160-f7a142e33c8f)

![image](https://github.com/user-attachments/assets/7812c343-832c-42d0-96ac-1417941994fe)

![image](https://github.com/user-attachments/assets/e70ae02b-7273-4828-b8a5-69fa603d664e)


---

## 🛠 Technologies Used
- **Spring Boot** (Spring Security, Spring MVC, Spring Data JPA)
- **Hibernate (JPA)**
- **Thymeleaf** (Frontend Templates)
- **PostgreSQL** (Database)
- **Maven** (Dependency Management)
- **BCrypt** (Password Hashing)
- **Java**

---

## 📂 Project Structure

<pre>
registration-login 
│── src 
│ ├── main 
│ │ ├── java/com/user/registration/registration_login 
│ │ │ ├── config                  # Security Configuration 
│ │ │ ├── controller              # Registration & Login Controllers 
│ │ │ │ ├── dto                   # Data Transfer Objects (DTO) 
│ │ │ ├── model                   # User & Role Entity Models 
│ │ │ ├── repository              # JPA Repository Interfaces 
│ │ │ ├── service                 # Service Interfaces 
│ │ │ │ ├── impl                  # Service Implementation
│ │ ├── resources 
│ │ │ ├── templates               # Frontend (HTML) 
│ │ │ │ ├── HTMLs
│ │ │ ├── application.properties  # Database & App Config 
│── pom.xml                       # Maven Dependencies 
│── README.md                     # Project Documentation
</pre>

---

## 📌 Endpoints


| HTTP Method | Endpoint             | Description                  |
|------------|----------------------|------------------------------|
| **GET**    | `/login`              | Login Page                   |
| **GET**    | `/index`              | Home Page after login        |
| **GET**    | `/registration`       | Registration page            |
| **POST**   | `/registration`       | Successful Registration      |
| **GET**    | `/logout`             | Logout user                  |

---

## 🔑 Default User Roles
By default, users are registered with the ROLE_USER. You can modify roles in the database.

---

## 🛠 Future Enhancements
- ✅ Email verification on registration
- ✅ Forgot Password functionality
- ✅ Admin Dashboard for user management
