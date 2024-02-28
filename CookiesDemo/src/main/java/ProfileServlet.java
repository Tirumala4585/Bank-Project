

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("Link.html");
		Cookie ck[] = request.getCookies();
		if(ck!=null)
		{
		   String name=ck[0].getValue();
		   if(!name.equals("") || name!=null) {
		       rd.include(request, response);	   
		       out.print("<h4>Welcome to profile Servlet</h4>");
		       out.print("<h4>Welcome to "+name+"</h4>");
		   }
		   else {
			   out.print("Please Login First");
			   RequestDispatcher rq  = request.getRequestDispatcher("Login.html");
			   rq.include(request,response);
		}
		
		}
		 else {
			   out.print("Please Login First");
			   RequestDispatcher rq  = request.getRequestDispatcher("Login.html");
			   rq.include(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
