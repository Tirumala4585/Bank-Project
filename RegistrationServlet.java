

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("uname");
		String email = request.getParameter("ename");
		String phno = request.getParameter("phname");
		String password = request.getParameter("pname");
		String conpass = request.getParameter("cname");
		PrintWriter out = response.getWriter();
		try {
		int rst=-1;  	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details","root","radha");
		PreparedStatement ps = con.prepareStatement("INSERT INTO register_details VALUES(?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,email);
		ps.setString(3,phno);
		ps.setString(4,password);
		ps.setString(5,conpass);
		rst=ps.executeUpdate();
;		if(rst==1)
		{
			response.sendRedirect("http://localhost:8082/RegistrationProject/SuccessfullServlet");
			
		}
        else
        {
        	out.print("Database not updated");
        }
		}
		catch(Exception ie) {
			out.print(ie);
		}
		doGet(request, response);
	}

}
