import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enter")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("myname");
		String dob  = req.getParameter("mydob");
		String phonenumber = req.getParameter("myphno");
		String emailid = req.getParameter("myemail");
		String gender = req.getParameter("gen");
		String username =  req.getParameter("myusername");
		String password = req.getParameter("mypwd");
		PrintWriter pw = resp.getWriter();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","@Reddy1358727");
			PreparedStatement ps = c.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, dob);
			ps.setString(3, phonenumber);
			ps.setString(4, emailid);
			ps.setString(5, gender);
			ps.setString(6, username);
			ps.setString(7, password);

			ps.executeUpdate();

			c.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		resp.sendRedirect("login.hmtl");
	}

}
