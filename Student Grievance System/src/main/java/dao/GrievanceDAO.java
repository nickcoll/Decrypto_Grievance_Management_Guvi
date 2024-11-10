package dao;

import model.Grievance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class GrievanceDAO {
    public void addGrievance(Grievance grievance) {
        String sql = "INSERT INTO grievances (student_id, description, submitted_date, status_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, grievance.getStudentId());
            stmt.setString(2, grievance.getDescription());
            stmt.setTimestamp(3, grievance.getSubmittedDate());
            stmt.setInt(4, grievance.getStatusId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grievance> getAllGrievances() {
        List<Grievance> grievances = new ArrayList<>();
        String sql = "SELECT * FROM grievances";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Grievance grievance = new Grievance(
                        rs.getInt("grievance_id"),
                        rs.getInt("student_id"),
                        rs.getString("description"),
                        rs.getTimestamp("submitted_date"),
                        rs.getInt("status_id")
                );
                grievances.add(grievance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grievances;
    }
}
