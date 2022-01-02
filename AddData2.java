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
 * Servlet implementation class AddData2
 */
public class AddData2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData2() {
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
		
		String url = "jdbc:mysql://localhost:3306/blood_bank";
		String username = "root";
		String password1 = "anu2001kumariA*";
		
		String name = request.getParameter("name");
		String btype = request.getParameter("btype");
		String qty = request.getParameter("qty");
		String hrecord = request.getParameter("hrecord");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		
		try 
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password1);

    		PreparedStatement ps = c.prepareStatement("insert into Donor_Data values(?, ?, ?, ?, ?, ?)");
			ps.setString(1, name);  
			ps.setString(2, btype); 
			ps.setString(3, qty);
			ps.setString(4, hrecord);
			ps.setString(5, contact);
			ps.setString(6, address);
			
			int check = ps.executeUpdate();  
			if(check>0)  
			{
				out.println("Record successfully added.");  
			}
			else
			{
				out.println("ERROR!");
			}

    		//out.println("<a href='BloodBankDonor'>Click here to return.</a>");
    		out.print("<a href='BloodBankDonor?n="+name+"'>Click here to return.</a>");
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