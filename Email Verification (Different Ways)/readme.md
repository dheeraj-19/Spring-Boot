# Email Verification in Spring Boot

This project demonstrates different ways to implement **email verification** in a **Spring Boot** application. It ensures that users **verify their email addresses** before gaining full access to the application.

---

## ✨ Features

- 🔒 **User Registration**  
- ✅ **Token-based Email Verification**
- 📂 **Database Integration** with JPA/Hibernate
- 🎨 **Thymeleaf Templates** for frontend UI 
- ✔️ **Spring Boot Email Service Integration**  
- 🏗 **Maven Project Structure**
- 📜 **MVC Architecture** (Controller, Service, Repository, Model)

---

## 📂 Email Formats

- **Simple Text Email**
- **Email With attachments**
- **Email With Embedded Images**
- **HTML Email**
- **HTML Email With Embedded Images**

---

## 🎨 Demo

🔒 **User Registration**


---

## 🛠️ Technologies Used

- **Spring Boot** – Backend framework
- **Hibernate (JPA)**
- **Thymeleaf** (Frontend Templates)
- **PostgreSQL** (Database)
- **Maven** (Dependency Management) 
- **Spring Data JPA** – Database interaction  
- **Spring Boot Mail** – Sending verification emails  

---

## 📂 Project Structure

<pre>
email/ 
├── src/ 
│ ├── main/ 
│ │ ├── java/com/email/email/ 
│ │ │ ├── controller          # Handles HTTP requests 
│ │ │ ├── model               # Database entities 
│ │ │ ├── repository          # JPA repositories 
│ │ │ ├── service             # Business logic 
│ │ │ │ ├── impl              # Business logic implementation 
│ │ │ ├── util                # Email contenet
│ │ │ ├── EmailVerificationApplication.java 
│ │ └── resources            
│ │ │ ├── images              # Attachments
│ │ │ ├── templates           # Email templates 
│ │ │ ├── static              # Frontend
│ │ │ ├── application.yml     # General Configurations
│ │ │ ├── application-dev.yml # Env specific configurations
├── pom.xml                   # Maven Dependencies
│── README.md                 # Project Documentation
</pre>

---

## 🚀 How It Works

1️⃣ User Registration
- User registers using the registration form.
- A verification email is sent to their inbox.

2️⃣ Email Verification
- User clicks the verification link received in the email.
- If successful, their account is activated.

---

## 📌 Endpoints


| HTTP Method | Endpoint             | Description                  |
|------------|----------------------|------------------------------|
| **POST**   | `/users`              | Create a new user            |
| **GET**    | `/users/token=?`      | Verify the user              |

---
