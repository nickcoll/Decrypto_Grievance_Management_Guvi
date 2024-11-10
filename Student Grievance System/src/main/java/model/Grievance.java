package model;

import java.sql.Timestamp;

public class Grievance {
    private int grievanceId;
    private int studentId;
    private String description;
    private Timestamp submittedDate;
    private int statusId;

    // Constructor
    public Grievance(int grievanceId, int studentId, String description, Timestamp submittedDate, int statusId) {
        this.grievanceId = grievanceId;
        this.studentId = studentId;
        this.description = description;
        this.submittedDate = submittedDate;
        this.statusId = statusId;
    }


    // Getters and setters
    public int getGrievanceId() {
        return grievanceId;
    }

    public void setGrievanceId(int grievanceId) {
        this.grievanceId = grievanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Timestamp submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
