package oop.orb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Charles Montero
 */
public class DBConnect {
    public static Connection getConnection() throws SQLException {
        // Replace these values with your database details
        String url = "jdbc:mysql://localhost:3306/OrbRegisters"; // Database URL
        String user = "root"; // Database username
        String password = "yourpassword"; // Database password

        // Create the connection
        return DriverManager.getConnection(url, user, password);
    }
}
