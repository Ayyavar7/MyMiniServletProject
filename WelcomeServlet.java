import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("uname");

		PrintWriter pw = resp.getWriter();
		pw.print("<h1>HELLO..."+username+"</h1>");
		pw.write("<h1>U HAVE LOGGED IN SUCCESSFULLY...</h1>");

	}
}
