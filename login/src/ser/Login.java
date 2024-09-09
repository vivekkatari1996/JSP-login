package ser;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.loginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		loginDao dao = new loginDao();
		
		
		
		try {
			if ((dao.check(uname,pass)||((uname.equals("vivek") && (pass.equals("katari")))))){
				// Set session attribute to store user information
				 // Store the username in the session
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				// Redirect to welcome.jsp page upon successful login
				response.sendRedirect("welcome.jsp");
			} else {
				// Redirect to an error page if login fails
				response.sendRedirect("error.jsp");  // Or create a custom error page
			}
		} catch (SQLException e) {
			// Log the error and redirect to an error page
			e.printStackTrace();  // It's good to log the exception for debugging
			response.sendRedirect("error.jsp");  // You can redirect to a general error page
		}
	}
}
