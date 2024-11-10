# Student Grievance Management System

A **Student Grievance Management System** that allows students to submit grievances, track their status, and manage the grievance lifecycle. This project is developed using **Java**, **Maven**, and connected to a **MySQL** database for backend storage.

## 📋 Features

- **Student Registration**: Allows students to register and store their details (name, email, department, etc.).
- **Grievance Submission**: Enables students to submit grievances, including descriptions and issue types.
- **Grievance Status Tracking**: Track grievance statuses like "Submitted", "Under Review", and "Resolved".
- **Database Interaction**: The system interacts with a MySQL database to store and retrieve data on students and grievances.

## 🔧 Technologies Used

- **Java**: Primary language for backend logic.
- **Maven**: Project management tool for building and managing dependencies.
- **MySQL**: Relational database to store student and grievance records.
- **JDBC**: Java Database Connectivity for database interactions.
- **Servlets/JSP** (Optional): If the web interface is implemented, servlets handle requests and JSP renders views.

## 🚀 Getting Started

Follow the steps below to get your local setup running:

### 📝 Prerequisites

Ensure the following tools are installed:

- **Java 8 or higher**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **MySQL**: [Download MySQL](https://dev.mysql.com/downloads/).
- **Maven**: [Download Maven](https://maven.apache.org/download.cgi).

1️⃣ Clone the Repository

Start by cloning the repository to your local machine:

```bash
git clone https://github.com/yourusername/student-grievance-system.git
```

2️⃣ Set Up the MySQL Database

1.Create a new database called student_grievance_system:

CREATE DATABASE grievance_system;


2.Set up the necessary tables for students and grievances:

-- Table for grievance details

CREATE TABLE grievances (
    grievance_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    description TEXT,
    submitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_id INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id));

-- Table for student details

CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(15),
    department VARCHAR(255),
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

3. Configure Database Connection
Edit your database connection settings in src/main/java/util/DBConnection

jdbc.url=jdbc:mysql://localhost:3306/student_grievance_system
jdbc.username=root
jdbc.password= "yourpassword"

