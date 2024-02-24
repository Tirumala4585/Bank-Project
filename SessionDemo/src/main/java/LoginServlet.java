

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userName="Tirumala rao";
	private final String pass="tiru";
       
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
		String password=request.getParameter("pname");
		if(name.equals(userName) && password.equals(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("user",name);
			response.sendRedirect("http://localhost:8083/SessionDemo/DashBoardServlet");
			
		}
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out = response.getWriter();
			out.print("<font color=red> Either username or password is failed</font>");
			rd.forward(request, response);
		}
	}

}
