
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

## 🚀 Getting Started

Follow the steps below to get your local setup running:

### 📝 Prerequisites

Ensure the following tools are installed:

- **Java 8 or higher**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **MySQL**: [Download MySQL](https://dev.mysql.com/downloads/).
- **Maven**: [Download Maven](https://maven.apache.org/download.cgi).

### 1️⃣ Clone the Repository

Start by cloning the repository to your local machine:

```bash
git clone https://github.com/yourusername/student-grievance-system.git
```

### 2️⃣ Set Up the MySQL Database

1. Create a new database called `student_grievance_system`:

   ```sql
   CREATE DATABASE student_grievance_system;
   ```

2. Set up the necessary tables for students and grievances:

```sql
-- Table for student details
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(15),
    department VARCHAR(255),
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for grievance details
CREATE TABLE grievances (
    grievance_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    description TEXT,
    submitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_id INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);
```

### 3️⃣ Configure Database Connection

Edit your database connection settings in `src/main/java/util/DBConnection.java`

```properties
jdbc.url=jdbc:mysql://localhost:3306/student_grievance_system
jdbc.username=root
jdbc.password="yourpassword"
```

### 4️⃣ Build the Project

Navigate to the project directory and build it using Maven:

```bash
mvn clean install
```

### 5️⃣ Run the Project

To run the project:

- **Using Tomcat/Servlet Container**: Deploy the `.war` file generated in `target/` to your Tomcat or other servlet container.
- **Using IDE**: You can run the application directly from an IDE like IntelliJ IDEA or Eclipse.

### 6️⃣ Access the Application

Once the application is deployed, access it via your browser (if a web interface is implemented). You can also interact with the backend directly for testing purposes.

## 🗂 Project Structure

```plaintext
student-grievance-system/
│
├── src/                             # Source files
│   ├── main/
│   │   ├── java/                    # Java source files (Model, DAO, Servlets)
│   │   ├── resources/               # Configuration files (e.g., db.properties)
│   │   └── webapp/                  # Web application files (e.g., JSP/HTML)
│   ├── test/                        # Test files (optional)
├── target/                          # Compiled artifacts (e.g., .war file)
├── .gitignore                       # Git ignore file
├── pom.xml                          # Maven configuration
└── README.md                        # Project readme (this file)
```

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Grievance Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Submit a Grievance</h2>
        <form id="grievance-form">
            <div class="mb-3">
                <label for="studentName" class="form-label">Name</label>
                <input type="text" class="form-control" id="studentName" placeholder="Enter your name" required>
            </div>
            <div class="mb-3">
                <label for="grievanceDescription" class="form-label">Grievance Description</label>
                <textarea class="form-control" id="grievanceDescription" rows="4" required></textarea>
            </div>
            <div class="mb-3">
                <label for="issueType" class="form-label">Issue Type</label>
                <select class="form-select" id="issueType" required>
                    <option value="">Select an issue</option>
                    <option value="Academic">Academic</option>
                    <option value="Administrative">Administrative</option>
                    <option value="Infrastructure">Infrastructure</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit Grievance</button>
        </form>

        <hr>

        <h3>Grievance Status</h3>
        <form id="status-form">
            <div class="mb-3">
                <label for="grievanceID" class="form-label">Grievance ID</label>
                <input type="text" class="form-control" id="grievanceID" placeholder="Enter your grievance ID" required>
            </div>
            <button type="submit" class="btn btn-secondary">Check Status</button>
        </form>

        <div id="status-result" class="mt-3"></div>
    </div>

    <script>
        document.getElementById('grievance-form').addEventListener('submit', function(event) {
            event.preventDefault();
            alert('Grievance Submitted!');
        });

        document.getElementById('status-form').addEventListener('submit', function(event) {
            event.preventDefault();
            var grievanceID = document.getElementById('grievanceID').value;
            document.getElementById('status-result').innerHTML = `<p>Status for Grievance ID ${grievanceID}: <strong>Under Review</strong></p>`;
        });
    </script>
</body>
</html>


## 🤝 How to Contribute

We welcome contributions to improve the system! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Added new feature'`).
5. Push the changes to your branch (`git push origin feature-branch`).
6. Open a pull request to merge your changes into the main branch.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🌟 Acknowledgements

- **MySQL**: For providing a powerful relational database.
- **Maven**: For making project management easier and more efficient.
- **Java**: For being the backbone of the backend implementation.

## 🔗 Useful Links

- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Java Documentation](https://docs.oracle.com/en/java/)
```
