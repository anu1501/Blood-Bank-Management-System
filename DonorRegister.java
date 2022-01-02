package BloodBankProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DonorRegister
 */
public class DonorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/Blood_Bank";
		String username = "root";
		String password1 = "anu2001kumariA*";
		
		try 
		{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password1);
			
			PreparedStatement ps = c.prepareStatement("insert into Donor_Login_Table(username, password) values(?, ?)");
			ps.setString(1, name);  
			ps.setString(2, password); 
			
			int check = ps.executeUpdate();  
			if(check>0)  
			out.print("You are successfully registered!");  
			out.println("<html><a href='donorlogin.html'>Click here to login.</a></html>");
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}