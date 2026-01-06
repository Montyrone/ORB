import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationMenu {

    public void saveUserToDatabase(String fullName, String email, String password) {
        // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/OrbRegisters";  // Your database URL
        String dbUsername = "root";  // Database username (change to your actual username)
        String dbPassword = "your_password";  // Database password (change to your actual password)

        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            try (Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
                // SQL query to insert a new user
                String sql = "INSERT INTO users (fullname, email, password) VALUES (?, ?, ?)";

                // Create PreparedStatement to insert the data
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, fullName);
                    statement.setString(2, email);
                    statement.setString(3, password);

                    // Execute the insert query
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to register. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error during registration. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
