import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginhere")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("uname");
		String password = req.getParameter("pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "root");
			PreparedStatement ps = c.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("welcome");
				rd.include(req, resp);
			}
			else {
				resp.setContentType("text/html");
				PrintWriter pw = resp.getWriter();
				pw.print("INCORRECT USERNAME OR PASSWORD....!!!");
				
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	
}
