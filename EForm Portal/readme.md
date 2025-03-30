# EForm Portal

This is an EForm Portal built using Spring Boot, Spring Security, Hibernate (JPA), PostgreSQL, and Angular. The application allows users to create dynamic forms, submit responses, and manage authentication securely.

---

## 🚀 Features

- 🔒 **User Authentication** (Registration & Login) with JWT
- ✅ **Role-Based Authorization** (Admin & User)
- 📝 **Dynamic Form Creation** with multiple question types (Text, Dropdown, Radio Button, etc.)
- 🛠 **Many-to-One Mapping** of questions to forms
- 📂 **Secure Form Submission and Response Storage**
- 🎨 **Angular Frontend** for an Interactive UI
- 🚀 **Spring Boot Security** Configuration
- 🏗 **Maven & Angular** Project Structure
- 📜 **MVC Architecture** (Model, Controller, Service, Repository)

---

## 🎨 Demo

https://github.com/user-attachments/assets/002aa8f1-1784-4564-abcb-02f6841ac907


---

## 🛠 Technologies Used

Backend (Spring Boot - portal)

- **Spring Boot** (Spring Security, Spring MVC, Spring Data JPA)
- **Hibernate** (JPA)
- **PostgreSQL** (Database)
- **Maven** (Dependency Management)

## 
Frontend (Angular - portal-web)
- **Angular**
- **TypeScript**
- **Angular Material**
- **Bootstrap**

---

## 📂 Project Structure

<pre>
EForm Portal

Backend - Spring Boot

│── portal (Backend - Spring Boot)
│ ├── src/main/java/com/eform/portal
│ │ ├── controller              # Form & User Controllers
│ │ ├── dto                     # Data Transfer Objects (DTO)
│ │ ├── entities                # Entity Models (User, Form, Question, Submission)
│ │ ├── enums                   # Values for user roles and question types  
│ │ ├── repository              # JPA Repository Interfaces
│ │ ├── service                 # Service Interfaces
│ │ │ ├── form                  # Form Function Implementations
│ │ │ ├── user                  # User Function Implementations
│ ├── resources
│ │ ├── application.properties  # Database & App Config

Frontend - Angular
  
│── portal-web (Frontend - Angular)
│ ├── src/app
│ │ ├── modules                 # All Modules
│ │ │ ├── admin                 # Admin Modules
│ │ │ │ ├── components          # Admin Components
│ │ │ │ │ ├── add-question-in-form
│ │ │ │ │ ├── create-form
│ │ │ │ │ ├── dashboard
│ │ │ │ │ ├── view-form
│ │ │ │ │ ├── view-form-submissions
│ │ │ │ ├── services            # Admin Services
│ │ │ ├── auth                  # Authentication Modules
│ │ │ │ ├── login               # Login Component
│ │ │ │ ├── services            # Authentication Services
│ │ │ │ ├── signup              # Signup Component
│ │ │ ├── shared                # Shared Modules
│ │ │ ├── user                  # User Modules
│ │ │ │ ├── components          # User Components
│ │ │ │ │ ├── dashboard         
│ │ │ │ │ ├── submit
│ │ │ │ │ ├── view-form-submissions  
│ │ │ │ ├── services            # User Services
│ ├── angular.json              # Angular Configurations
│── README.md                   # Project Documentation
</pre>

---

## 📌 Endpoints

### Authentication
| HTTP Method | Endpoint             | Description                  |
|------------|----------------------|------------------------------|
| **POST**   | `/api/auth/sign-up`   | Register a new user         |
| **POST**   | `/api/auth/login`     | Authenticate user & login   |

### Forms
| HTTP Method | Endpoint            | Description                  |
|------------|----------------------|------------------------------|
| **POST**   | `/api/form`          | Create a new form           |
| **GET**    | `/api/form`          | Get all forms               |

### Questions
| HTTP Method | Endpoint                           | Description                  |
|------------|------------------------------------|------------------------------|
| **POST**   | `/api/form/question`              | Add questions to a form     |
| **GET**    | `/api/form/{id}`                  | Retrieve questions for a form |

### Submissions
| HTTP Method | Endpoint                            | Description                    |
|------------|-------------------------------------|--------------------------------|
| **POST**   | `/api/form/submit-form`            | Submit responses              |
| **GET**    | `/api/form/form-submission`        | Get all submissions for all forms (Admin View) |
| **GET**    | `/api/form/form-submission/{id}`   | Get all submissions for all forms of a particular user (User View) |

---

## 🔑 Default User Roles
By default, users are registered with the ROLE_USER. Admin users have additional privileges.

---

## 🛠 Future Enhancements
- ✅ Admin panel for managing users
- ✅ Modifying/Deleting existing forms and questions
- ✅ Export form responses to CSV
- ✅ Email notifications on form submissions

---
