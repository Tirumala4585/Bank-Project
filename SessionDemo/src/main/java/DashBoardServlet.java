

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
 * Servlet implementation class DashBoardServlet
 */
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Object id = session.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(id!=null) {
			out.print("Name:"+" Tirumala rao </br>");
			out.print("Gmail:"+" jamitirumalarao52@gmail.com </br>");
			out.print("Phno:"+"8574963241 </br>");
			out.print("Address:"+"VIZAG </br>");
			String str="<form action=\"http://localhost:8083/SessionDemo/LogoutServlet\">\r\n"
					+ "<input type=\"submit\" value=\"Logout\">\r\n"
					+ "</form>";
			
			out.print(str);
			
			
		}
		else {
           out.print("Your Login details are failed");
           RequestDispatcher rd = request.getRequestDispatcher("Login.html");
           rd.include(request, response);
		}	
	}
}
