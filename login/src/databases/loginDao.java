package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {
	public static void main(String args[]) throws SQLException {
		loginDao dao = new loginDao();
		dao.check("navin", "9876");
		
	}

    // Method to check user credentials
    public boolean check(String uname, String pass) throws SQLException {
        boolean result = false;

        // Using try-with-resources to automatically close resources
        try (
            // Establish the connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vivek?useSSL=false&serverTimezone=UTC", "root", "root");
            // Prepare the SQL query to validate user credentials
            PreparedStatement str = con.prepareStatement("SELECT * FROM login WHERE uname = ? AND pass = ?");
        ) {
            // Set query parameters
            str.setString(1, uname);
            str.setString(2, pass);
            
            // Print the query and parameters for debugging
            System.out.println("Executing query with uname: " + uname + " and pass: " + pass);

            // Execute the query and retrieve the result
            try (ResultSet rs = str.executeQuery()) {
                // Check if a result is returned
                if (rs.next()) {
                    System.out.println("Login successful for user: " + uname);
                    result = true;
                } else {
                    System.out.println("Login failed for user: " + uname);
                }
            }
        } catch (Exception e) {
            // Log any exceptions
            e.printStackTrace();
        }

        return result;  // Return whether the login is successful or not
    }
}