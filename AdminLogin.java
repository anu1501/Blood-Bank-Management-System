package BloodBankProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String pass = "anu2001kumariA*";
		
		Cookie coo = new Cookie("username", name);
		response.addCookie(coo);
		
		try 
		{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, pass);
			
			if(checkUser(c, name, password))
			{
				out.println("Logged in successfully!");
				out.println("\n");
				
				out.println("<html><a href='BloodBankAdmin'>Click here to continue.</a></html>");
			}
			else
			{
				out.println("Username or Password incorrect");
			}
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
	
	 public boolean checkUser(Connection c, String name, String password) throws SQLException
	 {
         PreparedStatement ps = c.prepareStatement("select * from Admin_Login_Table where username=? and password=?");
         ps.setString(1, name);
         ps.setString(2, password);
         ResultSet rs = ps.executeQuery();
         return rs.next();
	 }
	}