package app; // Add the correct package name here if needed

import model.Student;
import model.Grievance;
import dao.StudentDAO;
import dao.GrievanceDAO;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        // Initialize DAOs
        StudentDAO studentDAO = new StudentDAO();
        GrievanceDAO grievanceDAO = new GrievanceDAO();

        // Create a new student
        Student student = new Student(
                0,  // studentId will be auto-generated
                "John Doe",
                "john.doe@example.com",
                "1234567890",
                "Computer Science",
                new Timestamp(System.currentTimeMillis())  // Enrollment date as current timestamp
        );

        // Add student to the database
        studentDAO.addStudent(student);
        System.out.println("Student added: " + student.getName());

        // Create a new grievance
        Grievance grievance = new Grievance(
                0,  // grievanceId will be auto-generated (no need to pass it, set to 0)
                student.getStudentId(),  // studentId for the grievance
                "Complaint about the grading system",
                new Timestamp(System.currentTimeMillis()), // Use current timestamp for submittedDate
                1  // statusId, assuming 1 = Pending (for example)
        );

        // Add grievance to the database
        grievanceDAO.addGrievance(grievance);
        System.out.println("Grievance added for student ID: " + student.getStudentId());

        // Fetch all students and print them
        System.out.println("\nAll Students:");
        for (Student s : studentDAO.getAllStudents()) {
            System.out.println("ID: " + s.getStudentId() + ", Name: " + s.getName() + ", Email: " + s.getEmail());
        }

        // Fetch all grievances and print them
        System.out.println("\nAll Grievances:");
        for (Grievance g : grievanceDAO.getAllGrievances()) {
            System.out.println("Grievance ID: " + g.getGrievanceId() + ", Student ID: " + g.getStudentId() + ", Description: " + g.getDescription());
        }
    }
}
