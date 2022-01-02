package BloodBankProject;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBloodBank
 */
public class ViewBloodBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBloodBank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/blood_bank";
		String username = "root";
		String password1 = "anu2001kumariA*";
		
		out.println("<html><style>h1 {text-align: center;}</style>");
		out.println("<style>p {text-align: center;}</style>");
		out.println("<style>.center {margin-left: auto; margin-right: auto;}</style></html>");
		
		out.println("<html><body><form method='post' action='SearchDonor'>"+
		           "Enter Blood Type: "+ "<input type='text' name='type'/><br/><br/>"+
				   "<input type='submit' value='Submit'/><br/>"
				   + "</form></body></html>"); 
	 
		
		out.println("<h1>BLOOD BANK DATA</h1>");  
		try 
		{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password1);
			String query = "select * from Donor_Data";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
    		
			out.print("<table class='center' border='1' width='75%'");  
	        out.print("<tr><th>Name</th>"
	        			+ "<th>Blood Type</th>"
	        			+ "<th>Blood Quantity (ml)</th>"
	        			+ "<th>Contact Number</th>"
	        		+ "</tr>");
	        
    		while(rs.next()) 
    		{
    			 out.print("<tr>"
    			 				+"<td>"+rs.getString(1)+"</td>"
    			 				+"<td>"+rs.getString(2)+"</td>"
    			 				+"<td>"+rs.getInt(3) +"</td>"
    			 				+"<td>"+rs.getString(5)+"</td>"
        			 			+"</tr>"); 
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
		
		out.println("<p>For more details contact Admin (+919438268143)</p>");
		out.println("\n");
		out.println("\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}