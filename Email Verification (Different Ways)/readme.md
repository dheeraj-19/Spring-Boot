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

![image](https://github.com/user-attachments/assets/8fb9deac-8d19-4f8a-a1ec-2263d5b52ee4)

![image](https://github.com/user-attachments/assets/45802e43-6735-4dc7-9441-14649c3d4f6c)

![image](https://github.com/user-attachments/assets/4a9fd57b-5b5b-4e6c-b7db-bd59a472ebb3)

##
📂 **Simple Text Email**

![image](https://github.com/user-attachments/assets/889472b9-58da-4c61-9b5a-57285c5503a4)

##
📂 **Email With attachments**

![image](https://github.com/user-attachments/assets/b13708be-a4e6-4d02-8ba7-1b7c10767845)

##
📂 **Email With Embedded Images**

![image](https://github.com/user-attachments/assets/3e07acb4-e596-4208-97d4-40256af0ba15)

##
📂 **HTML Email**

![image](https://github.com/user-attachments/assets/7bb01884-478a-426c-8d4d-143bc4311244)

##
📂 **HTML Email With Embedded Images**

![image](https://github.com/user-attachments/assets/d612f9b1-ad6a-41a4-b50f-82a3dad5db0b)

##
✅ **Token-based Email Verification**

![image](https://github.com/user-attachments/assets/4c983a05-77d3-4839-bc68-5402b77c087d)


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
