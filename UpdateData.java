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
 * Servlet implementation class UpdateData
 */
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
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
		
		String url = "jdbc:mysql://localhost:3306/Blood_Bank";
		String username = "root";
		String password1 = "anu2001kumariA*";
		
		String name = request.getParameter("name");
		String qty = request.getParameter("qty");
		String hrecord = request.getParameter("hrecord");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		
		try 
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, username, password1);

    		PreparedStatement ps = c.prepareStatement("update Donor_Data set blood_quantity=?, health_record=?, contact_no=?, address=? where name= ?");
			ps.setString(1, qty);  
			ps.setString(2, hrecord); 
			ps.setString(3, contact);
			ps.setString(4, address);
			ps.setString(5, name);
			
			int check = ps.executeUpdate();  
			if(check>0)  
			{
				out.println("Record updated successfully!");  
			}
			else
			{
				out.println("ERROR!");
			}
			
    		out.println("<a href='BloodBankAdmin'>Click here to return</a>");
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