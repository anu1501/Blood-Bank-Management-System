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
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/blood_bank";
		String username = "root";
		String password1 = "anu2001kumariA*";
		
		try 
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password1);
			
			String contact = request.getQueryString();
			String[] con = contact.split("=");
			String de  = con[1];
			
			PreparedStatement ps = c.prepareStatement("delete from Donor_Data where contact_no = ?");
    		ps.setString(1, de);
//    		
    		int record = ps.executeUpdate();
    		if(record == 1)
    		{
    				out.println("Deleted succesfully!");
    		}
    		else 
    		{
    				out.println("Record not found.");
    		}
    		
    		out.println("<a href='BloodBankAdmin'>Click here to return.</a>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}