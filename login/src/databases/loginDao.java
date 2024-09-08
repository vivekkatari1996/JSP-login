package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {
	// Method to check user credentials
    public boolean check(String uname, String pass) throws SQLException {
        // Initialize necessary variables
        Connection con = null;
        PreparedStatement str = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            // Load the MySQL driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vivek", "root", "root");

            // Prepare the SQL query to validate user credentials
            str = con.prepareStatement("SELECT * FROM login WHERE uname = ? AND pass = ?");
            str.setString(1, uname);
            str.setString(2, pass);

            // Execute the query
            rs = str.executeQuery();

            // Check if any result is returned
            if (rs.next()) {
                result = true;
            }

        } catch (Exception e) {
         System.out.println("Not working");
        }
            // Log the exception for debugging
       finally {
            // Close resources to prevent memory leaks
            if (rs != null) rs.close();
            if (str != null) str.close();
            if (con != null) con.close();
        }
        return result;  // Return whether the login is successful or not
    }


}
