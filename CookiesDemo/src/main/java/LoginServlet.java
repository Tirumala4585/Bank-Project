

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("Link.html");
		rd.include(request, response);
		if(name.equals("Ramesh")&&pass.equals("ram")) {
			Cookie ck = new Cookie("user",name);
			response.addCookie(ck);
			out.println("<h1>You are successfully loggined</h1>");
			
		}
        else {
        	out.print("Login Details are failed");
        	RequestDispatcher rd1 = request.getRequestDispatcher("Login.html");
        	rd1.include(request, response);
        }
  	}

}
