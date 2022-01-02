package BloodBankProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BloodBankDonor
 */
public class BloodBankDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodBankDonor() {
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
		
		String fname = request.getParameter("fname");
		String n = request.getParameter("n");
		String na = request.getParameter("na");
		
		out.println("<html><style>h1 {text-align: center;}</style>");
		out.println("<style>.center {margin-left: auto; margin-right: auto;}</style>");
		out.println("<h1>YOUR RECORD</h1></html>"); 
		
		try 
		{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password1);
			//Statement stmt = c.createStatement();
			
			
			String query = "select * from Donor_Data where name = ?";
			PreparedStatement ps = c.prepareStatement(query);
			if(n!=null)
			{
				ps.setString(1, n); 
			}
			else if(fname!=null)
			{
				ps.setString(1, fname);  
			} 
			else if(na!=null)
			{
				ps.setString(1, na);
			}
			//String query = "select from Donor_Data where name="+fname;
			ResultSet rs = ps.executeQuery();
    		
			out.print("<table class='center' border='1' width='75%'");  
	        out.print("<tr><th>Name</th>"
	        			+ "<th>Blood Type</th>"
	        			+ "<th>Blood Quantity (ml)</th>"
	        			+ "<th>Health Record</th>"
	        			+ "<th>Contact Number</th>"
	        			+ "<th>Address</th>"
	        		+ "</tr>");
	        
    		while(rs.next()) 
    		{
    			 out.print("<tr>"
    			 				+"<td>"+rs.getString(1)+"</td>"
    			 				+"<td>"+rs.getString(2)+"</td>"
    			 				+"<td>"+rs.getInt(3) +"</td>"
    			 				+"<td>"+rs.getString(4)+"</td>"
    			 				+"<td>"+rs.getString(5)+"</td>"
    			 				+"<td>"+rs.getString(6)+"</td>"
        			 			+"</tr>"); 
    		}
    		
    		out.println("<html><style>p {text-align: center;}</style>");
    		out.print("<p><a href='updatedonor2.html'>Update Record</a></p></html>");
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