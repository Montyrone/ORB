/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.orb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistration {
    public boolean registerUser(String fullname, String email, String password) {
        // SQL query to check if the email already exists
        String checkEmailQuery = "SELECT * FROM users WHERE email = ?";
        // SQL query to insert the new user into the database
        String insertQuery = "INSERT INTO users (fullname, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DBConnect.getConnection()) {  // Using the DatabaseConnection class
            // Check if the email already exists
            try (PreparedStatement checkStmt = connection.prepareStatement(checkEmailQuery)) {
                checkStmt.setString(1, email);
                ResultSet resultSet = checkStmt.executeQuery();
                
                if (resultSet.next()) {
                    // Email already exists
                    System.out.println("This email is already registered.");
                    return false;
                }
            }

            // Insert the new user if email is not already in use
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setString(1, fullname);
                insertStmt.setString(2, email);
                insertStmt.setString(3, password); // It's advisable to hash the password before storing it

                int rowsAffected = insertStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("User registered successfully!");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}